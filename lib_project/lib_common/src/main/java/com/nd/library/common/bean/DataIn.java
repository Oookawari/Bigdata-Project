package com.nd.library.common.bean;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName:DataIn
 * @Description:数据输入
 * @Author:huge823865619
 * @Date:2022/7/2 21:06
 * @Version: 1.0
 */
public interface DataIn extends Closeable {
    void setPath(String path1, String path2);

    //输入路径
    void setPath(String path);
    //读取数据
    Object read() throws IOException;
    //<T extends Data> List<T> read(Class<T> clazz)throws IOException;

    <T extends com.nd.library.common.bean.Data> List<T> read(Class<T> clazz) throws IOException;

    <T extends Data> List<T> readUser(Class<T> clazz) throws IOException;

    <T extends Data> List<T> readBook(Class<T> clazz) throws IOException;
}
