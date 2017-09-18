package com.fenfei.ssh.shiro;

import com.fenfei.ssh.pojos.system.Administrator;
import com.fenfei.ssh.service.IAdministratorService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by shefenfei on 2017/8/13.
 * 核心的Realm实现
 */
public class AdminRealm extends AuthorizingRealm {

    @Resource
    private IAdministratorService administratorService;

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {

        String username = (String) token.getPrincipal(); //用户名
        char[] password = (char[]) token.getCredentials();//密码
        String p = new String(password);
        Administrator administrator = administratorService.login(username, p);
        if (administrator == null) { //不存在这个用户 ，抛出UnknownAccountException
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                administrator.getAdminName(),
                administrator.getAdminPass(),
                ByteSource.Util.bytes(administrator.getAdminName()),
                getName()
        );

        return authenticationInfo;
    }


    /**
     * 提供用户权限角色信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        String username = (String) principal.getPrimaryPrincipal();

        Set<String> roles = new HashSet<>();
        Set<String> permissions = new HashSet<>();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Administrator administrator = administratorService.getAdminRoleAndPerms(username);
        if (null != administrator) {
            administrator.getRoles().parallelStream().forEach(role -> {
                roles.add(role.getRoleName());
            });

            administrator.getPermissions().parallelStream().forEach(permission -> {
               permissions.add(permission.getPermName());
            });
        }
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }


}
