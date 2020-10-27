package vip.epss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

//第一个项目案例采用lombok的插件方式,有助于减小大家的压力,但是可能会引起阅读代码的障碍,所以本项目部分实体类会采用这种方式
@Data   //启用了lombok插件,相当于@ToString、@EqualsAndHashCode、@Getter、@Setter和@RequiredArgsConstrutor
@NoArgsConstructor  //lombok自动生成空参构造器
@AllArgsConstructor //lombok自动生成全参构造器
@JsonIgnoreProperties(value = "handler")    //用于解决mybatis关联查询时使用了懒加载方式过程中数据封装引发的问题
public class Goods implements Serializable {
    private Integer gid;

    private String gname;

    private String gdes;

    private Double gprice;

    private String gavatar;

    private Integer fbid;

    private Business business;

    private Integer ftid;

    private Types types;

    private Date addTime;
}