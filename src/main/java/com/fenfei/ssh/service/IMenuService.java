package com.fenfei.ssh.service;

import com.fenfei.ssh.pojos.system.Menu;

import java.util.List;

/**
 * Created by shefenfei on 2017/8/15.
 * IMenuService 获取按钮有关的api
 */
public interface IMenuService {

    /**
     * 获取所有的菜单
     * @return
     */
    List<Menu> listAllMenu();

}
