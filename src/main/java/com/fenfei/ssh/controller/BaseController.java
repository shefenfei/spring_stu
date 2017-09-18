package com.fenfei.ssh.controller;

import com.fenfei.ssh.pojos.ResponseResult;

/**
 * Created by shefenfei on 2017/8/30.
 */
public class BaseController {

    ResponseResult buildSuccessResp() {
        ResponseResult result = new ResponseResult();
        result.setMessage("成功");
        result.setStatus(200);
        return result;
    }

}
