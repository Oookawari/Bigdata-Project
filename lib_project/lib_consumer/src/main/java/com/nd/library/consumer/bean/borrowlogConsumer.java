/**
 * @description: 借书日志消费者接口实现
 * @author: Group-16
 * @date: 2022-07-18 10:44
 */
package com.nd.library.consumer.bean;

import com.nd.library.common.bean.Consumer;
import com.nd.library.common.constant.Names;
import com.nd.library.consumer.Dao.HBaseDao;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class borrowlogConsumer implements Consumer {
    public void consumer() throws IOException {
        Properties prop = new Properties();
        //获取配置信息
        prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("consumer.properties"));

        KafkaConsumer<String,String> consumer=new KafkaConsumer<String, String>(prop);
        //关注主题
        consumer.subscribe(Arrays.asList(Names.TOPIC.getValue()));

        HBaseDao hBaseDao = new HBaseDao();
        hBaseDao.init();
        //消费数据
        while(true){
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
                //将数据存进去
                hBaseDao.insertData(record.value());
            }
        }

    }

    public void close() throws IOException {

    }
}
