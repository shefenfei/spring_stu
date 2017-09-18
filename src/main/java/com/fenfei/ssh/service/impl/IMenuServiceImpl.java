package com.fenfei.ssh.service.impl;

import com.fenfei.ssh.dao.IMenuDao;
import com.fenfei.ssh.pojos.system.Menu;
import com.fenfei.ssh.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shefenfei on 2017/8/15.
 */
@Service
public class IMenuServiceImpl implements IMenuService {

    @Resource
    private IMenuDao menuDao;

    @Override
    public List<Menu> listAllMenu() {
        return menuDao.getAllSysMenus();
    }
}
