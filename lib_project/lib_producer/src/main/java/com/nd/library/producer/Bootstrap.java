package com.nd.library.producer;

import com.nd.library.common.bean.Producer;
import com.nd.library.producer.bean.LocalFileProducer;
import com.nd.library.producer.io.LocalFileDataIn;
import com.nd.library.producer.io.LocalFileDataOut;

import java.io.IOException;

/**
 * @ClassName:Bootstrap
 * @Description:启动对象
 * @Author:huge823865619
 * @Date:2022/7/2 21:28
 * @Version: 1.0
 */
public class Bootstrap {
    public static void main(String[] args) throws IOException {
        if(args.length<=0){
            System.out.println("系统参数不正确，请按照格式传参：");
            System.exit(1);
        }
       // 构建生产者对象
        Producer producer=new LocalFileProducer();

//        producer.setIn(new LocalFileDataIn("C:\\Users\\86137\\Desktop\\A_VIPFiles\\A-Intership\\Data\\pro\\User.log","C:\\Users\\86137\\Desktop\\A_VIPFiles\\A-Intership\\Data\\pro\\Book.log"));
//        producer.setOut(new LocalFileDataOut("C:\\Users\\86137\\Desktop\\A_VIPFiles\\A-Intership\\Data\\pro\\borrow.log"));

        producer.setIn(new LocalFileDataIn(args[0],args[1]));
        producer.setOut(new LocalFileDataOut(args[2]));
        //生产数据

        producer.produce();
        //关闭生产者对象
        producer.close();
    }
}
