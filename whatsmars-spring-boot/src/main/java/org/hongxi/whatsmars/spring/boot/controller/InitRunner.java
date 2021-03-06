package org.hongxi.whatsmars.spring.boot.controller;

import org.hongxi.whatsmars.spring.boot.async.MessageService;
import org.hongxi.whatsmars.spring.boot.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by shenhongxi on 2017/6/29.
 */
@Component
@Order(value = 1)
public class InitRunner implements CommandLineRunner {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MessageService messageService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("init......createIfNotExistsTable");
        userMapper.createIfNotExistsTable();

        for (int i = 0; i < 10; i++) {
            messageService.send("message" + i);
        }
    }
}
