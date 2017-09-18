package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by shefenfei on 2017/8/11.
 */
@WebAppConfiguration(value = "src/main/resources")
@ContextConfiguration(locations = {
        "classpath:configs/spring/spring-mvc.xml",
        "classpath:configs/spring/spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestController extends AbstractJUnit4SpringContextTests {

//    @Autowired
//    private IUserService userService;

    @Autowired
    private RedisTemplate<String , Object> redisTemplate;

//    @Resource(name = "redisTemplate")
//    private ListOperations<String , String> listOperations;

    @Test
    public void testRedis() {
//        User user = userService.getUser("1");
//        listOperations.leftPush("userId" , "1");
//        User user = userService.getUser("1");
//        redisTemplate.delete("password");
//        redisTemplate.boundListOps("age").leftPush("27");
        redisTemplate.opsForValue().set("friendabc" , "zhangwentao");
//        User value = (User) redisTemplate.opsForValue().get("getUser");
//        redisTemplate.opsForValue().getOperations().delete("getUser");
        System.out.println("test" + "....");
    }

}
