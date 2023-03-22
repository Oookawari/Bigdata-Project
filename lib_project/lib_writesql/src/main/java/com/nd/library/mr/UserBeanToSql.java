package com.nd.library.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.util.StringTokenizer;

public class UserBeanToSql {
    //写一个mapper
    public static class UserMapper extends Mapper<LongWritable,Text, Text,UserBean>
    {
        private Text k=new Text();
        private UserBean v=new UserBean();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //获取一行数据
            String line=new String(value.getBytes(),0,value.getLength(),"GBK");
            //分割
            StringTokenizer sti=new StringTokenizer(line);
            v.setuID(sti.nextToken());
            v.setUname(sti.nextToken());
            v.setUage(sti.nextToken());
            k.set(v.getuID());
            //输出
            context.write(k,v);
        }
    }
    //写一个Reducer
    public static class UserReducer extends Reducer<Text,UserBean,UserBean,NullWritable>{
        @Override
        protected void reduce(Text key, Iterable<UserBean> values, Context context) throws IOException, InterruptedException {
            UserBean bean = values.iterator().next();
            UserBean k=new UserBean(bean.getuID(),bean.getUname(),bean.getUage());
            context.write(k,NullWritable.get());
        }
    }

    //Driver阶段
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        BasicConfigurator.configure();//使用缺省的log4j
        //创建配置对象
        Configuration conf=new Configuration();
        //连接数据库
        DBConfiguration.configureDB(conf,"com.mysql.jdbc.Driver",
                "jdbc:mysql://192.168.138.101:3306/library?characterEncoding=utf-8",
                "root","root");
        //获取job对象
        Job job = Job.getInstance(conf);
        //设置jar位置
        job.setJarByClass(UserBeanToSql.class);
        //关联mapper和reducer
        job.setMapperClass(UserMapper.class);
        job.setReducerClass(UserReducer.class);
        //设置mapper输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(UserBean.class);
        //设置最终输出类型
        job.setOutputKeyClass(UserBean.class);
        job.setOutputValueClass(NullWritable.class);
        //设置输入输出路径
        FileInputFormat.setInputPaths(job,new Path("C:\\Users\\86137\\Desktop\\A_VIPFiles\\A-Intership\\Data\\pro\\User.log"));
        String[] fields={"uID","uname","uage"};
        DBOutputFormat.setOutput(job,"user",fields);
        //提交
        boolean result = job.waitForCompletion(true);
        System.exit(result?0:1);
    }


}