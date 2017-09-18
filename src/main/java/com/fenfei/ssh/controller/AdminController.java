package com.fenfei.ssh.controller;

import com.fenfei.ssh.pojos.ResponseResult;
import com.fenfei.ssh.pojos.system.Administrator;
import com.fenfei.ssh.pojos.system.Permission;
import com.fenfei.ssh.pojos.system.Role;
import com.fenfei.ssh.service.IAdministratorService;
import com.fenfei.ssh.service.ILogService;
import com.fenfei.ssh.utils.SystemControllerLog;
import com.mchange.v2.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by shefenfei on 2017/8/17.
 * 系统登录及其它功能的控制器
 */
@Controller
@RequestMapping(path = "/system")
public class AdminController extends BaseController{

    @Resource
    private IAdministratorService administratorService;
    @Resource
    private HttpServletRequest request;
    @Resource
    private ILogService logService;


    @Resource
    private Environment environment;

    /**
     * 管理员登录界面
     *
     * @return
     */
    @SystemControllerLog(description = "管理员登录界面")
    @GetMapping(path = "/adminLogin")
    public String adminLogin() {
        System.out.println(environment.getProperty("datasource.jdbcUrl"));
        return "admin/login";
    }


    /**
     * 执行登录
     *
     * @return
     */
    @SystemControllerLog(description = "执行管理员登录")
    @PostMapping(path = "/doLogin")
    public String doLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password) {

        UsernamePasswordToken token = null;
        Subject subject = null;
        if (StringUtils.nonEmptyString(username)
                && StringUtils.nonEmptyString(password)) {
            Administrator administrator = administratorService.login(username, password);
            if (null != administrator) { //1 ,验证成功，数据库存在此用户
                token = new UsernamePasswordToken(username, password); //2. 登录Shiro框架
                subject = SecurityUtils.getSubject();
                if (!subject.isAuthenticated()) {
                    token.setRememberMe(true);
                }
                subject.login(token);
                request.getSession().setAttribute("current_admin" , administrator);
                boolean is = subject.isPermitted("Add");
                System.out.println(is);
                return "redirect:/home/index";
            }
        }
        return "redirect:/system/adminLogin";
    }

    /**
     * 退出登录
     * @return
     */
    @SystemControllerLog(description = "管理员退出登录")
    @GetMapping(path = "/signOut")
    @ResponseBody
    public String signOut() {
        return "";
    }

    /**
     * 跳转管理员页面
     * @return
     */
    @SystemControllerLog(description = "管理员列表页")
    @GetMapping(path = "/adminList")
    public String gotoAdminPage() {
        return "admin/admins";
    }

    /**
     * 获取所有管理员数据
     * @return
     */
    @GetMapping(path = "/getAllAdmin")
    @ResponseBody
    public List<Administrator> getAllAdmin() {
        return administratorService.getAllAdmin();
    }

    /**
     * 获取所有的管理员角色
     * @return
     */
    @GetMapping(path = "/getAllRoles")
    @ResponseBody
    public List<Role> getAllRoles() {
        return administratorService.getAllRoles();
    }


    /**
     * 获取所有的权限信息
     * @return
     */
    @GetMapping(path = "/getAllPerms")
    @ResponseBody
    public List<Permission> getAllPerms() {
        return administratorService.getAllPerms();
    }


    /**
     * 添加新管理员
     * @param admin
     * @return
     */
    @PostMapping(path = "/addNewAdmin")
    @ResponseBody
    public Map<String , Object> addNewAdmin(Administrator admin , @RequestParam("rId") List<Integer> roles) {
        return administratorService.addNewAdmin(admin , roles);
    }


    /**
     * 删除系统管理员
     * @param adminId
     * @return
     */
    @SystemControllerLog(description = "删除系统管理员")
    @PostMapping(path = "/delAdminById/{adminId}")
    @ResponseBody
    public ResponseResult delAdminById(@PathVariable("adminId") String adminId) {
        return buildSuccessResp();
    }
}
