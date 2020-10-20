package vip.epss.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Customer {
    private Integer cid;

    private String cname;

    private String cphone;

    private String cemail;

    private String cpass;

    private Date cbirth;

    private String cavatar;

    private Boolean cgender;

    private Boolean cstatus;

    private Date addTime;

}