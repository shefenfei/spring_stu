package tests;

import com.fenfei.ssh.dao.IAdminDao;
import com.fenfei.ssh.pojos.system.AdminRole;
import com.fenfei.ssh.pojos.system.Administrator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shefenfei on 2017/8/25.
 */
@WebAppConfiguration(value = "src/main/resources")
@ContextConfiguration(locations = {
        "classpath:configs/spring/spring-mvc.xml",
        "classpath:configs/spring/spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MyBatisTest {

    @Resource
    private IAdminDao adminDao;

    @Test
    public void test() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        List<Administrator> adminInIds = adminDao.getAdminInIds(ids);
        for (Administrator administrator : adminInIds) {
            System.out.println(administrator.getAdminName());
        }
    }

    @Test
    public void testInsertList() {
        Administrator administrator = new Administrator();
        administrator.setAdminName("admin1");
        administrator.setAdminPass("admin1");

        adminDao.addNewAdmin(administrator);
        List<Integer> ids = new ArrayList<>();
        for (int i=1;i < 3; i++) {
            ids.add(i);
        }

        int aId = Integer.valueOf(administrator.getId());

        List<AdminRole> adminRoles = new ArrayList<>();
        for (Integer id: ids) {
            AdminRole adminRole = new AdminRole();
            adminRole.setRoleId(id);
            adminRole.setAdminId(aId);
            adminRoles.add(adminRole);
        }

        int count = adminDao.addAdminRoles(adminRoles);
        System.out.println(count);
    }


    @Test
    public void testInsertMap() {
        Administrator administrator = new Administrator();
        administrator.setAdminName("admin233");
        administrator.setAdminPass("admin122");

        adminDao.addNewAdmin(administrator);
        List<Integer> ids = new ArrayList<>();
        for (int i=1;i < 3; i++) {
            ids.add(i);
        }

        int aId = Integer.valueOf(administrator.getId());

        Map<String, Object> map = new HashMap<>();
        map.put("adId" , aId);
        map.put("rIds" , ids);

        int count = adminDao.addAdminRoles1(map);
        System.out.println(count);
    }




}
