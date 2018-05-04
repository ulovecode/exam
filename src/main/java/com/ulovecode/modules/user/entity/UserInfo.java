package com.ulovecode.modules.user.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@Accessors(chain = true)
@Data
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

}