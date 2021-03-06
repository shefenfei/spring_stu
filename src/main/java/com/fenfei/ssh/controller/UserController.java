package com.fenfei.ssh.controller;

import com.fenfei.ssh.pojos.User;
import com.fenfei.ssh.service.IUserService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by shefenfei on 2017/7/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Resource
    private IUserService userService;

    /**
     * 显示用户信息
     * @return
     */
    @GetMapping("/userDetail")
    public String showUserInfo() {
        return "userInfo";
    }

    /**
     * 获取所有的用户
     * @return
     */
    @GetMapping(path = "/getAllUser")
    @ResponseBody
    public List<User> getAllUser() {
        return userService.findAllUser();
    }


    @GetMapping(path = "/userList")
    public String userListPage() {
        return "admin/users";
    }


    @ApiOperation(value = "添加用户" , httpMethod = "POST")
    @PostMapping(path = "/addNewUser")
    public String addNewUser(HttpServletRequest request , @ApiParam(required = true, name = "postData", value = "用户信息") User user) {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        return "";
    }

}
