package vip.epss.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/15 0015
 * @描述
 */
public class StringToDateConvert implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        System.out.println("String 转 Date 的方法开始执行了");

        if(source==null || "".equals(source)){
            throw new RuntimeException("没有传入对应的字符串");
        }
        Date date = null;
        String formatStr=null;
        if(source.length() > 10){
            formatStr = "yyyy-MM-dd HH:mm";
            source = source.replace("T"," ");
        }else{
            formatStr = "yyyy-MM-dd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatStr);
        try {
            date = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("String 转 Date 的方法执行结束了");
        return date;//绑定失败时返回null
    }
}
