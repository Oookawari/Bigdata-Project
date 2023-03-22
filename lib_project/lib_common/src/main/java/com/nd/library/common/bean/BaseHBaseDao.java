package com.nd.library.common.bean;

import com.nd.library.common.constant.Names;
import com.nd.library.common.constant.ValueConstant;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 基础数据访问对象抽象类
 * @author: Group-16
 * @date: 2022-07-18 11:21
 */

public abstract class BaseHBaseDao {
    private  ThreadLocal<Connection> connHolder = new ThreadLocal<Connection>();

    private ThreadLocal<Admin> adminHolder = new ThreadLocal<Admin>();

    protected  void start() throws IOException {
        getConnect();//获取连接
        getAdmin();//获取admin
    }

    protected void end() throws IOException {
        Admin admin = getAdmin();
        if(admin!=null){
            admin.close();
            adminHolder.remove();
        }
        Connection conn = getConnect();
        if(conn!=null){
            conn.close();
            connHolder.remove();
        }
    }

    protected synchronized Admin getAdmin() throws IOException {
        Admin admin = adminHolder.get();
        if(admin==null){
            admin=getConnect().getAdmin();
            adminHolder.set(admin);
        }
        return admin;
    }

    protected synchronized Connection getConnect() throws IOException {
       Connection conn = connHolder.get();
        if(conn==null) {
            Configuration conf = HBaseConfiguration.create();
            //获取连接对象
            conn = ConnectionFactory.createConnection(conf);
            connHolder.set(conn);
        }
        return conn;
    }

    protected void createTableTX(String name,String...families) throws IOException {
        createTableTX(name,null,families);
    }

    protected void createTableTX(String name,Integer regionCount, String...families) throws IOException {
        Admin admin=getAdmin();
        TableName tableName = TableName.valueOf(name);
        if (admin.tableExists(tableName)) {
            //表存在，删除表
            deleteTable(name);
        }



        //创建表
        createTable(name,regionCount,families);
    }

    private void createTable(String name,Integer regionCount, String...families) throws IOException {
        Admin admin=getAdmin();
        TableName tableName = TableName.valueOf(name);
        //列族
        if(families.length==0||families==null){
            families=new String[1];
            families[0]= Names.LIB_INFO.getValue();
        }

        HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);

        for(String family : families){
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(family);
            hTableDescriptor.addFamily(hColumnDescriptor);
        }

        if(regionCount==null||regionCount<=0){
            admin.createTable(hTableDescriptor);
        }else{

            byte[][] splitKeys=genSplitKey(regionCount);
            admin.createTable(hTableDescriptor,splitKeys);
        }



    }

    //生成分区键
    private byte[][] genSplitKey(Integer regionCount){
        int splitKeyCount = regionCount - 1;
        byte[][] bs=new byte[splitKeyCount][];//写一个二维数组,为分区键
        //分区键:0|,1|,2|,3|,4|
        //[负无穷,0|),[0|,1|),[1|,2|),[2|,3|),[3|,4|),[4|,正无穷)
        List<byte[]> bsList=new ArrayList<byte[]>();
        for (int i = 0; i < splitKeyCount; i++) {
            String splitKey=i+"|";
            System.out.println(splitKey);
            bsList.add(Bytes.toBytes(splitKey));
        }
        bsList.toArray(bs);
        return bs;

    }

    protected void deleteTable(String name) throws IOException {
        TableName tableName = TableName.valueOf(name);
        Admin admin=getAdmin();
        admin.disableTable(tableName);
        admin.deleteTable(tableName);
    }

    protected void createNamespaceNX(String namespace) throws IOException {
        Admin admin = getAdmin();
        try {
            //获取命名空间描述器
            admin.getNamespaceDescriptor(namespace);
        }catch (NamespaceNotFoundException e){
            //e.printStackTrace();
            //创建命名空间描述器
            NamespaceDescriptor namespaceDescriptor = NamespaceDescriptor.create(namespace).build();
            //创建命名空间
            admin.createNamespace(namespaceDescriptor);
        }

    }

    protected void putData(String name, List<Put> puts) throws IOException {
        Connection connect = getConnect();
        Table table = connect.getTable(TableName.valueOf(name));
        table.put(puts);
        table.close();
    }

    protected void putData(String name, Put put) throws IOException {
        Connection connect = getConnect();
        Table table = connect.getTable(TableName.valueOf(name));
        table.put(put);
        table.close();
    }

    //获取分区号：分区号是对uid后四位、bid后三位进行哈希得到
    protected int genRegionNum(String uid, String bid){
        String userCode=uid.substring(uid.length()-4);
        String bookCode=bid.substring(uid.length()-3);
        //进行哈希
        int userCodeHash=userCode.hashCode();
        int bookCodeHash=bookCode.hashCode();
        //crc校验：采用异或算法
        int crc=Math.abs(userCodeHash^bookCodeHash);
        //模取分区数（为6）
        int regionNum = crc% ValueConstant.REGION_COUNT;
        return regionNum;
    }


    protected List<String[]> getStartRowKeys(){
        List<String[]> rowKeyss=new ArrayList<String[]>();
        return null;
    }
}