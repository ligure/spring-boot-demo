package com.ligure.repository.mongo;

import com.ligure.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/3/16.
 */
@Repository
public interface UserMongoRepository extends MongoRepository<User, Long> {
    User findByUserid(String userid);
}
