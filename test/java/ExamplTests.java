package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by shefenfei on 2017/7/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configs/spring/spring-redis.xml")
public class ExamplTests {

//    @Autowired
    private JedisPool jedisPool;

    @Test
    public void testRedis() {
        Jedis jedis = jedisPool.getResource();
        jedis.set("username" , "shefenfei");
        System.out.println(jedis.get("key1"));
        jedis.close();
    }

}
