package com.ff.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ff.common.entity.dto.SessionUserAdminDto;
import com.ff.common.entity.enums.AccountStatusEnum;
import com.ff.common.entity.po.Account;
import com.ff.common.mapper.AccountMapper;

@Service
public class AccountService {

    private final Account account;

    @Autowired
    private AccountMapper accountMapper;

    AccountService(Account account) {
        this.account = account;
    }

    public SessionUserAdminDto login(String phone, String password) throws Exception {
        LambdaQueryWrapper<Account> wrapper = new LambdaQueryWrapper<>();
        Account account = accountMapper.selectOne(wrapper.eq(Account::getPhone, phone));
        if (account == null) {
            throw new Exception("账号密码错误");
        }

        if (AccountStatusEnum.DISABLE.getStatus().equals(account.getStatus())) {
            throw new Exception("账号已禁用");
        }

        if (!account.getPassword().equals(password)) {
            throw new Exception("账号密码错误");
        }

        SessionUserAdminDto adminDto = new SessionUserAdminDto();
        adminDto.setSuperAdmin(true);
        adminDto.setUserId(account.getUserId());
        adminDto.setUserName(account.getUserName());
        return adminDto;
    }
}
