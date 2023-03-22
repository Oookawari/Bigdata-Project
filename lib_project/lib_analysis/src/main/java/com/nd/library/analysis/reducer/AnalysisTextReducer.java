package com.nd.library.analysis.reducer;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @ClassName:AnalysisTextReducer
 * @Description:分析数据Reducer
 * @Author:huge823865619
 * @Date:2022/7/10 22:55
 * @Version: 1.0
 */
public class AnalysisTextReducer extends Reducer<Text, Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        //统计通话次数
        //sumborrow为计数变量，记录键值相同的元组的数量
        int sumborrow=0;
        for (Text value : values) {

            sumborrow++;
        }
        //输出
        context.write(key,new Text(Integer.toString(sumborrow)));
    }
}