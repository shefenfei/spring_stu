package com.fenfei.ssh.controller;

import com.fenfei.ssh.pojos.system.Menu;
import com.fenfei.ssh.service.IMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shefenfei on 2017/8/15.
 * 菜单控制器
 */
@Controller
@RequestMapping(path = "/menu")
public class MenuController {

    @Resource
    private IMenuService menuService;

    /**
     * 获取所有的菜单
     * @return
     */
    @PostMapping(path = "/listAllMenu")
    @ResponseBody
    public List<Menu> fetchAllMenu() {
        List<Menu> menus = menuService.listAllMenu();
        System.out.println("/listAllMenu");
        return menus;
    }

}
