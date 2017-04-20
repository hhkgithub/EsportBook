package com.esportbook.entity;

/**
 * Created by hhkmac on 2017/4/18.
 */
public class User {
    private int userseq;
    private String userid;
    private String username;
    private int usersex;
    private int userage;
    private String userphone;
    private String useraddress;

    public int getUserseq() {
        return userseq;
    }

    public void setUserseq(int userseq) {
        this.userseq = userseq;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUsersex() {
        return usersex;
    }

    public void setUsersex(int usersex) {
        this.usersex = usersex;
    }

    public int getUserage() {
        return userage;
    }

    public void setUserage(int userage) {
        this.userage = userage;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }
}
