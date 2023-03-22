package com.nd.library.common.bean;

import java.io.Closeable;
import java.io.IOException;

public interface Consumer extends Closeable {
    //消费数据
    void consumer() throws IOException;
}

