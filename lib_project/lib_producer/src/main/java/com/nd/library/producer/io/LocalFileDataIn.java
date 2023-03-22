package com.nd.library.producer.io;

import com.nd.library.common.bean.Data;
import com.nd.library.common.bean.DataIn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:LocalDataIn
 * @Description:本地数据输入
 * @Author:huge823865619
 * @Date:2022/7/2 21:37
 * @Version: 1.0
 */
public class LocalFileDataIn implements DataIn {
    private BufferedReader readUser=null;//字符输入流
    private BufferedReader readBook=null;
    public LocalFileDataIn(String path1,String path2) {
        setPath(path1,path2);
    }

//    public LocalFileDataIn(String path) {
//        setPath(path);
//    }

    @Override
    public void setPath(String path1,String path2) {
        try {
            readUser=new BufferedReader(new InputStreamReader(new FileInputStream(path1),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            readBook=new BufferedReader(new InputStreamReader(new FileInputStream(path2),"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setPath(String path) {

    }

    @Override
    public Object read() throws IOException {
        return null;
    }

    @Override
    public <T extends Data> List<T> read(Class<T> clazz) throws IOException {
        return null;
    }

//    public <T extends javax.xml.crypto.Data> List<T> read(Class<T> clazz) throws IOException {
//        return null;
//    }

    /**
     * 读取数据，返回集合
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    @Override
    public <T extends Data> List<T> readUser(Class<T> clazz) throws IOException {
        //写一个集合
        List<T> ts=new ArrayList();
        try {
            //从数据文件中读取所有数据
            String line=null;
            while((line=readUser.readLine())!=null){//读取数据不为空
                //将我们数据转换为指定类型的对象，封装为集合返回
                T t = clazz.newInstance();
                t.setValue(line);
                ts.add(t);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ts;
    }
    @Override
    public <T extends Data> List<T> readBook(Class<T> clazz) throws IOException {
        //写一个集合
        List<T> ts=new ArrayList();
        try {
            //从数据文件中读取所有数据
            String line=null;
            while((line=readBook.readLine())!=null){//读取数据不为空
                //将我们数据转换为指定类型的对象，封装为集合返回
                T t = clazz.newInstance();
                t.setValue(line);
                ts.add(t);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ts;
    }
    @Override
    public void close() throws IOException {
        if(readUser!=null){
            readUser.close();
        }
        if(readBook!=null){
            readBook.close();
        }
    }
}
