package com.ulovecode.modules.user.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Accessors(chain = true)
@Data
@ApiModel("用户信息")
public class
UserInfo implements Serializable {
    @ApiModelProperty(value = "用户id",example = "111",position = 1)
    private String userid;

    @ApiModelProperty(value = "真实姓名",example = "朱博文",position = 2)
    private String realname;

    @ApiModelProperty(value = "密码",example = "111",position = 3)
    private String passwd;

    @ApiModelProperty(value = "登陆时间",position = 4)
    private Date loginDtime;
    @ApiModelProperty(value = "登出时间",position = 5)
    private Date logoutDtime;
    @ApiModelProperty(value = "登陆地址",example = "127.0.0.1",position = 6)
    private String loginHost;


}