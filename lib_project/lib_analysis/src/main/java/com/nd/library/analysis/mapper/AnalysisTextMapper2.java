package com.nd.library.analysis.mapper;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

/**
 * @ClassName:AnalysisTextMapper
 * @Description:分析数据mapper
 * @Author:huge823865619
 * @Date:2022/7/10 22:51
 * @Version: 1.0
 */
public class AnalysisTextMapper2 extends TableMapper<Text, Text> {
    @Override
    protected void map(ImmutableBytesWritable key, Result value, Context context)
            throws IOException, InterruptedException {
        /*
        5_104991_10017_2022-6-15_2022-7-30
         */
        String rowKey= Bytes.toString(key.get());
        String[] values = rowKey.split("_");
//拆分数据
        String uID=values[1];
        String bID=values[2];
        String brwTime=values[3],retTime=values[4];//retTime不晓得用得到不
        String[] values2 = brwTime.split("-");
        String year=values2[0];
        String month=values2[1];
        String day=values2[2];


        context.write(new Text(uID),new Text(retTime));//主叫月

    }
}