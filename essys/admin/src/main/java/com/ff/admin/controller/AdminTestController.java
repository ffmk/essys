package com.ff.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ff.common.entity.po.Account;
import com.ff.common.mapper.AccountMapper;

@RestController
public class AdminTestController {

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("admin/test")
    public String test() {
        System.out.println("---------------普通分页------------");
        accountMapper.selectList(null).forEach(System.out::println);
        System.out.println("---------------page分页------------");
        IPage<Account> page = accountMapper.selectPage(new Page<>(2, 1), null);
        System.out.println(page.getRecords());
        return "创建admin测试";
    }

}
