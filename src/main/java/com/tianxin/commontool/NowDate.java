package com.tianxin.commontool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public   class  NowDate {


    /**
     * Author : tianxin 
     * CreateTime : 2020/5/31 0031 17:31
     * param  : 
     * retuen :当前时间字符串
     * Description :获取当前系统时间
     */
    public  static String NowDateTime(){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        return dateFormat.format(date);
    }

    public   String NowTime(){
        Calendar cal=Calendar.getInstance();
        int y=cal.get(Calendar.YEAR);
        int m=cal.get(Calendar.MONTH);
        int d=cal.get(Calendar.DATE);
        int h=cal.get(Calendar.HOUR_OF_DAY);
        int mi=cal.get(Calendar.MINUTE);
        int s=cal.get(Calendar.SECOND);
        return y+"年"+m+"月"+d+"日"+h+"时"+mi+"分"+s+"秒";
    }
    


}
