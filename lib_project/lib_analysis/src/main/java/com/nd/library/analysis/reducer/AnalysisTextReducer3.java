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
public class AnalysisTextReducer3 extends Reducer<Text, Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int duration=0;//借书时长
        for (Text value : values) {//获取不同键值对的借书时长
            duration=Integer.parseInt(value.toString());
        }
        context.write(key,new Text(String.valueOf(duration)));
    }
}