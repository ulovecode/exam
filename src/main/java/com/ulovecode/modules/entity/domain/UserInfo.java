package com.ulovecode.modules.entity.domain;

import java.io.Serializable;
import java.util.Date;

public class
UserInfo implements Serializable {
    private String userid;

    private String realname;

    private String passwd;

    private Date loginDtime;

    private Date logoutDtime;

    private String loginHost;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Date getLoginDtime() {
        return loginDtime;
    }

    public void setLoginDtime(Date loginDtime) {
        this.loginDtime = loginDtime;
    }

    public Date getLogoutDtime() {
        return logoutDtime;
    }

    public void setLogoutDtime(Date logoutDtime) {
        this.logoutDtime = logoutDtime;
    }

    public String getLoginHost() {
        return loginHost;
    }

    public void setLoginHost(String loginHost) {
        this.loginHost = loginHost == null ? null : loginHost.trim();
    }
}