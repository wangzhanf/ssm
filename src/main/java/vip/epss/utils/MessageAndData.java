package vip.epss.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回的数据要包括实体类内容或者实体类的集合
 * 消息
 * 状态:
 * 所以创建一个通用的消息封装体
 */
public class MessageAndData {
    private Integer statusCode;//返回状态码,类似于HTTP的4xx表示失败  2xx表示成功
    private String message;//提示消息
    private Map<String,Object> dataZone = new HashMap<>();//封装获取到的实体类对象或集合

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getDataZone() {
        return dataZone;
    }

    public void setDataZone(Map<String, Object> dataZone) {
        this.dataZone = dataZone;
    }

//    提供一个快速封装数据的方法
    public MessageAndData add(String key, Object value){
        this.getDataZone().put(key,value);//追加数据到数据区
        return this;//返回对象自身,这样就可以链式操作了
    }
//    提供一个失败和成功的快速方法,避免创建对象
    public static MessageAndData success(String msg){
        MessageAndData messageAndData = new MessageAndData();
        messageAndData.setStatusCode(200);
        msg = "".equals(msg)?"调用成功":msg;
        messageAndData.setMessage(msg);
        return messageAndData;
    }

    public static MessageAndData error(String msg){
        MessageAndData messageAndData = new MessageAndData();
        messageAndData.setStatusCode(400);
        msg = "".equals(msg)?"调用失败":msg;
        messageAndData.setMessage(msg);
        return messageAndData;
    }
}
