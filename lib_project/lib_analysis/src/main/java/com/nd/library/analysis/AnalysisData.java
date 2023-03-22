package com.nd.library.analysis;

import com.nd.library.analysis.tool.AnalysisTextTool;
import com.nd.library.analysis.tool.AnalysisTextTool2;
import com.nd.library.analysis.tool.AnalysisTextTool3;
import org.apache.hadoop.util.ToolRunner;

/**
 * @ClassName:AnalysisData
 * @Description:分析数据
 * @Author:huge823865619
 * @Date:2022/7/10 22:16
 * @Version: 1.0
 */
public class AnalysisData {
    public static void main(String[] args) throws Exception {
        ToolRunner.run(new AnalysisTextTool(), args);//生成borrowTimes表
        ToolRunner.run(new AnalysisTextTool2(), args);//生成userorrowTimes表
        ToolRunner.run(new AnalysisTextTool3(), args);//生成noncompliance表
    }
}