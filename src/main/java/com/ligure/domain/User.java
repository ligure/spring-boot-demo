package com.ligure.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/15.
 */
@ApiModel("用户信息")
@Entity
@Table
public class User implements Serializable {
    @ApiModelProperty("主键ID")
    private int id;
    @ApiModelProperty("用户ID")
    private String userid;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("姓名|昵称")
    private String nickname;
    @ApiModelProperty("电子邮箱")
    private String email;
    private int status;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Column
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
