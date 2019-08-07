package garin.javaredis;

import junit.framework.Assert;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaredisApplicationTests {


    @Test
    public void contextLoads() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch ( Exception e) {
            //5、身份验证失败
        }
//        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        //6、退出
        subject.logout();
    }

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads2() {

        List list = redisTemplate.getClientList();

        System.out.println();
    }

    @Test
    public void contextLoads1() {

        RedisProperties.Jedis jedis = new RedisProperties.Jedis();

//        jedis.set("1","a");
//        jedis.lpush("l2","gg1");
//        jedis.lpush("l2","gg2");
//        jedis.lpush("l2","gg3");

//        jedis.hset("hash", "1", "a");
//        jedis.hset("hash", "2", "b");
//
//        System.out.println(jedis.get("1"));
//        System.out.println(jedis.lrange("l2", 0, 10));
//        System.out.println(jedis.hgetAll("hash"));
//        System.out.println(jedis.hget("hash", "2"));
//        jedis.close();
    }

}
