package com.ulovecode.modules.user.controller;

import com.ulovecode.common.utils.R;
import com.ulovecode.modules.user.entity.UserInfo;
import com.ulovecode.modules.user.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    UserInfoService userInfoService;


    @RequestMapping("/login")
    public R login(@RequestBody UserInfo userInfo) {
        if (userInfo == null) {
            return R.error("空信息");
        }
        String userid = userInfo.getUserid();
        String passwd = userInfo.getPasswd();
        if (userid != null) {
            Optional<UserInfo> dbuserInfo = userInfoService.queryObject(Optional.ofNullable(userid));
            if (dbuserInfo.isPresent()) {
                UserInfo info = dbuserInfo.get();
                if (info.getPasswd().equals(passwd)) {
                    return R.ok("userinfo", info);
                }
            }
        }

        return R.error("账号或密码错误");
    }
}
