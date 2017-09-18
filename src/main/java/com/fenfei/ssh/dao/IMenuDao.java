package com.fenfei.ssh.dao;

import com.fenfei.ssh.pojos.system.Menu;

import java.util.List;

/**
 * Created by shefenfei on 2017/8/15.
 */
public interface IMenuDao {

    List<Menu> getAllSysMenus();
}
