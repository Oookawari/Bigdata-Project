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

public class BookBeanToSql {
    //写一个mapper
    public static class BookMapper extends Mapper<LongWritable,Text, Text,BookBean>
    {
        private Text k=new Text();
        private BookBean v=new BookBean();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            //获取一行数据
            String line=new String(value.getBytes(),0,value.getLength(),"UTF-8");
            //分割
            StringTokenizer sti=new StringTokenizer(line);
            v.setbID(sti.nextToken());
            v.setBname(sti.nextToken());
            v.setAuthor(sti.nextToken());
            v.setBcategory(sti.nextToken());
            k.set(v.getbID());
            //输出
            context.write(k,v);
        }
    }
    //写一个Reducer
    public static class BookReducer extends Reducer<Text,BookBean,BookBean,NullWritable>{
        @Override
        protected void reduce(Text key, Iterable<BookBean> values, Context context) throws IOException, InterruptedException {
            BookBean bean = values.iterator().next();
            BookBean k=new BookBean(bean.getbID(),bean.getBname(),bean.getAuthor(),bean.getBcategory());
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
        job.setJarByClass(BookBeanToSql.class);
        //关联mapper和reducer
        job.setMapperClass(BookMapper.class);
        job.setReducerClass(BookReducer.class);
        //设置mapper输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(BookBean.class);
        //设置最终输出类型
        job.setOutputKeyClass(BookBean.class);
        job.setOutputValueClass(NullWritable.class);
        //设置输入输出路径
        FileInputFormat.setInputPaths(job,new Path("C:\\Users\\86137\\Desktop\\A_VIPFiles\\A-Intership\\Data\\pro\\Book.log"));
        String[] fields={"bID","bname","author","bcategory"};
        DBOutputFormat.setOutput(job,"book",fields);
        //提交
        boolean result = job.waitForCompletion(true);
        System.exit(result?0:1);
    }



}