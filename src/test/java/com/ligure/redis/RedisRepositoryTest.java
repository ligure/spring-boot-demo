package com.ligure.redis;

import com.ligure.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisRepositoryTest {

    @Resource
    RedisTemplate<String, User> template;

    @Test
    public void add() {
        User u = new User();
        u.setId(1);
        u.setNickname("一");
        template.opsForValue().set("1", u);
        u = new User();
        u.setId(2);
        u.setNickname("二");
        template.opsForValue().set("2", u);
        u = new User();
        u.setId(3);
        u.setNickname("三");
        template.opsForValue().set("3", u);
    }

    @Test
    public void get() {
        Assert.assertEquals(template.opsForValue().get("1").getNickname(), "一");
        Assert.assertEquals(template.opsForValue().get("2").getNickname(), "二");
        Assert.assertEquals(template.opsForValue().get("3").getNickname(), "三");
    }

    @Test
    public void del() {
        Iterator<String> it = template.keys("*").iterator();
        String k = "";
        while (it.hasNext()) {
            k = it.next();
            template.delete(k);
        }
    }

}
