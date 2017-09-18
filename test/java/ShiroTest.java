package tests;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Created by shefenfei on 2017/8/11.
 */
//@WebAppConfiguration(value = "src/main/resources")
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(name = "shiro" ,locations = "")
public class ShiroTest {

    @Test
    public void testShiro(){
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:configs/shiro/user.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken passwordToken = new UsernamePasswordToken("shefenfei" , "123456");
        try {
            subject.login(passwordToken);
        }catch (AuthenticationException e) {
            System.out.println("身份认证失败..." + e.getMessage());
        }

//        Assert.assertEquals(true , subject.isAuthenticated());
    }
}
