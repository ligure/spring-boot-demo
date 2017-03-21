package com.ligure.repository.jpa;

import com.ligure.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/3/16.
 */
@Repository
@CacheConfig(cacheNames = "users")
public interface UserJpaRepository extends JpaRepository<User, Long> {
    @Cacheable(key = "#p0")
    User findByUserid(String userid);
}
