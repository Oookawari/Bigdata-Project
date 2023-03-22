package com.nd.library.producer.bean;

import com.nd.library.common.bean.DataIn;
import com.nd.library.common.bean.DataOut;
import com.nd.library.common.bean.Producer;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @ClassName:LocalFileProducer
 * @Description:本地数据文件生产者
 * @Author:huge823865619
 * @Date:2022/7/2 21:18
 * @Version: 1.0
 */
public class LocalFileProducer implements Producer {
    private DataIn in;
    private DataOut out;
    private Random r = new Random();
    private volatile boolean flag=true;//增强进程可见性，进程共享
    @Override
    public void setIn(DataIn in) {
        this.in=in;
    }

    @Override
    public void setOut(DataOut out) {
        this.out=out;
    }
    //生产数据
    @Override
    public void produce(){
        int month1,month2,day1,day2,t;//借还书日期
        String uid,bid;
        try{
            //读取已有数据
            List<User> userList = in.readUser(User.class);
            List<Book> bookList = in.readBook(Book.class);

            for(int i=0;i<20000;i++){//生成borrow表
                //随机取uid
                int userIndex=r.nextInt(userList.size());
                int bookIndex=r.nextInt(bookList.size());
                uid = userList.get(userIndex).getUid();
                bid = bookList.get(bookIndex).getBid();
                //生成借还书日期
                month2 = month1 = r.nextInt(6) + 1;
                t= r.nextInt(28) + 1;
                if (month1 == 2) {
                    day1 = r.nextInt(28) + 1;
                    day2 = day1 + t;
                    if(day2>28){
                        day2-=28;
                        month2++;
                    }
                }
                else if (month1 == 4 || month1 == 6) {
                    day1 = r.nextInt(30) + 1;
                    day2 = day1 + t;
                    if(day2>30){
                        day2-=30;
                        month2++;
                    }
                }
                else{
                    day1 = r.nextInt(31) + 1;
                    day2 = day1 + t;
                    if(day2>31){
                        day2-=31;
                        month2++;
                    }
                }
                Borrow borrow = new Borrow(uid,bid,month1,month2,day1,day2);
                System.out.println(borrow);
                out.write(borrow);

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //关闭生产者
    @Override
    public void close() throws IOException {
        if(in!=null){
            in.close();
        }
        if(out!=null){
            out.close();
        }
    }
}
