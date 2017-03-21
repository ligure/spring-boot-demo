package com.ligure.mongo;

import com.ligure.domain.User;
import com.ligure.repository.mongo.UserMongoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoRepositoryTest {

    @Resource
    UserMongoRepository repository;

    @Test
    public void add() {
        User u = new User();
        u.setId(1);
        u.setNickname("一");
        repository.save(u);
    }

    @Test
    public void list() {
        repository.findAll();
    }

}
