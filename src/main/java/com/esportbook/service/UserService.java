package com.esportbook.service;

import com.esportbook.entity.User;
import com.esportbook.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hhkmac on 2017/4/18.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(int userseq){
       return this.userMapper.findUserBySeq(userseq);
    }
}
