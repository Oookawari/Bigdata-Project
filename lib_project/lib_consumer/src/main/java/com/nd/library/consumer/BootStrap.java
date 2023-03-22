package com.nd.library.consumer;

import com.nd.library.common.bean.Consumer;
import com.nd.library.consumer.bean.borrowlogConsumer;

import java.io.IOException;

/**
 * @description: 消费者启动类
 * @author: Group-16
 * @date: 2022-07-18 10:59
 */

public class BootStrap {
    public static void main(String[] args) throws IOException {
        Consumer consumer = new borrowlogConsumer();
        consumer.consumer();
        consumer.close();
    }
}