package com.nd.library.analysis.mapper;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName:AnalysisTextMapper
 * @Description:分析数据mapper
 * @Author:huge823865619
 * @Date:2022/7/10 22:51
 * @Version: 1.0
 */
public class AnalysisTextMapper3 extends TableMapper<Text, Text> {

    //计算借书时长
    private static int differentDays(Date date1,Date date2) {
        //获取对象
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);

        if(year1 != year2) {//不同年
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)//判断是否是闰年
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        } else {// 同年
            //System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
}
    @Override
    protected void map(ImmutableBytesWritable key, Result value, Context context)
            throws IOException, InterruptedException {
        /*
        5_104991_10017_2022-6-15_2022-7-30
         */
        //拆分数据
        String rowKey= Bytes.toString(key.get());
        String[] values = rowKey.split("_");
        String uID=values[1];
        String bID=values[2];
        String brwTime=values[3];
        String retTime=values[4];

        //统一时间格式
        String[] brw = brwTime.split("-");
        String bmonth=brw[1];
        //一位数月份或者天数得加上0变成两位数。如：1月->01月
        bmonth="0"+bmonth;
        String bday=brw[2];
        if(bday.length()==1)
            bday="0"+bday;
        String[] ret = retTime.split("-");
        String rmonth=ret[1];
        rmonth="0"+rmonth;
        String rday=ret[2];
        if(rday.length()==1)
            rday="0"+rday;

        String brwTime2="2022-"+bmonth+"-"+bday;
        String retTime2="2022-"+rmonth+"-"+rday;
        //System.out.println(brwTime2+"          "+retTime2);
        try {
            int duration=0;
          //计算借书时长
            DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = dft.parse(brwTime2);
            Date date2 = dft.parse(retTime2);
            duration=differentDays(date1,date2);  //
            //System.out.println(duration);
            if (duration > 25) {//超过25天算违约！
                String Duration=Integer.toString(duration);
                context.write(new Text(uID+"_"+bID),new Text(Duration));//主叫月
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}