package vip.epss.domain;

import lombok.Data;

import java.util.Date;
@Data

public class User {
    private Integer uid;

    private String username;

    private String password;

    private Date addTime;

    public User() {
    }

    public User(Integer uid, String username, Date addTime){
        this.uid = uid;
        this.username = username;
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", addTime=" + addTime +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}