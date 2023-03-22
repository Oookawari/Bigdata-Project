package com.nd.library.consumer.Dao;

import com.nd.library.common.bean.BaseHBaseDao;
import com.nd.library.common.constant.Names;
import com.nd.library.common.constant.ValueConstant;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 基础数据访问对象
 * @author: Group-16
 * @date: 2022-07-18 11:20
 */

public class HBaseDao extends BaseHBaseDao {
    public void init() throws IOException {
        start();
        //创建命名空间
        createNamespaceNX(Names.NAMESPACE.getValue());
        //创建有分区的表
        createTableTX(Names.TABLE.getValue(), ValueConstant.REGION_COUNT, Names.LIB_BORROW.getValue());
        end();
    }


    public void insertData(String value) throws IOException {
        String[] values = value.split("\t");
        String uid=values[0];
        String bid=values[1];
        String brwTime=values[2];
        String retTime=values[3];

        //生成rowKey，此处为：分区号+所有属性列信息
        String rowKey=genRegionNum(uid,bid)+"_"+uid+"_"+bid+"_"+brwTime+"_"+retTime;
        Put put=new Put(Bytes.toBytes(rowKey));//变成字节
        byte[] family=Bytes.toBytes(Names.LIB_BORROW.getValue());
        put.addColumn(family,Bytes.toBytes("Uid"),Bytes.toBytes(uid));
        put.addColumn(family,Bytes.toBytes("Bid"),Bytes.toBytes(bid));
        put.addColumn(family,Bytes.toBytes("brwTime"),Bytes.toBytes(brwTime));
        put.addColumn(family,Bytes.toBytes("retTime"),Bytes.toBytes(retTime));
        //把数据放进表中
        putData(Names.TABLE.getValue(),put);
    }
}