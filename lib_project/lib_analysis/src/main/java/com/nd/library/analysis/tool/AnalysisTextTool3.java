package com.nd.library.analysis.tool;

import com.nd.library.analysis.io.MySQLTextOutputFormat;
import com.nd.library.analysis.io.MySQLTextOutputFormat2;
import com.nd.library.analysis.io.MySQLTextOutputFormat3;
import com.nd.library.analysis.mapper.AnalysisTextMapper;
import com.nd.library.analysis.mapper.AnalysisTextMapper2;
import com.nd.library.analysis.mapper.AnalysisTextMapper3;
import com.nd.library.analysis.reducer.AnalysisTextReducer;
import com.nd.library.analysis.reducer.AnalysisTextReducer2;
import com.nd.library.analysis.reducer.AnalysisTextReducer3;
import com.nd.library.common.constant.Names;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.JobStatus;
import org.apache.hadoop.util.Tool;


/**
 * @ClassName:AnalysisData
 * @Description:分析数据的工具类
 * @Author:huge823865619
 * @Date:2022/7/10 22:17
 * @Version: 1.0
 */
public class AnalysisTextTool3 implements Tool {
    @Override
    public int run(String[] args) throws Exception {
        //获取job
        Job job= Job.getInstance();
        //设置jar位置
        job.setJarByClass(AnalysisTextTool3.class);
        //扫描主叫列族
        Scan scan=new Scan();
        scan.addFamily(Bytes.toBytes(Names.LIB_BORROW.getValue()));
        //设置mapper
        TableMapReduceUtil.initTableMapperJob(
                Names.TABLE.getValue(),
                scan,
                AnalysisTextMapper3.class,
                Text.class,
                Text.class,
                job
        );
        //设置reducer
        job.setReducerClass(AnalysisTextReducer3.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        //设置输出
        job.setOutputFormatClass(MySQLTextOutputFormat3.class);
        //提交
        boolean flag = job.waitForCompletion(true);
        if(flag){
            return JobStatus.State.SUCCEEDED.getValue();
        }else{
            return JobStatus.State.FAILED.getValue();
        }
    }

    @Override
    public void setConf(Configuration conf) {

    }

    @Override
    public Configuration getConf() {
        return null;
    }
}