package com.ligure.web.controller;

import com.ligure.domain.User;
import com.ligure.repository.jpa.UserJpaRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */
@RestController
@RequestMapping("/user")
class UserController {

    @Resource
    UserJpaRepository repository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表")
    public List<User> list() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{userid:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户ID获取用户信息")
    public User get(@PathVariable String userid) {
        return repository.findByUserid(userid);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "保存用户信息")
    public User save(@RequestBody User user) {
        return repository.saveAndFlush(user);
    }

    @RequestMapping(value = "/batchsave", method = RequestMethod.POST)
    @ApiOperation(value = "批量保存用户信息")
    public List<User> save(@RequestBody List<User> users) {
        for (User u : users) {
            repository.saveAndFlush(u);
        }
        return users;
    }

}
