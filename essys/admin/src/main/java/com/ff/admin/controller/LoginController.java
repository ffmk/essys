package com.ff.admin.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ff.admin.annotation.GlobalInterceptor;
import com.ff.common.service.AccountService;
import com.ff.common.util.CaptchaUtils;
import com.ff.common.util.Result;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private AccountService accountService;

    // 验证码 Session 键名
    private static final String CAPTCHA_SESSION_KEY = "CAPTCHA";

    @GetMapping("captcha")
    public void captcha(HttpServletResponse rep, HttpServletRequest req) throws IOException {
        // 生成验证码
        String code = CaptchaUtils.generateCode();
        BufferedImage image = CaptchaUtils.generateImage(code);

        // 存储到 Session
        HttpSession session = req.getSession();
        session.setAttribute(CAPTCHA_SESSION_KEY, code);

        // 写入响应流
        CaptchaUtils.writeToResponse(image, rep);
    }

    @GlobalInterceptor
    @PostMapping("login")
    public ResponseEntity<String> login(HttpSession session, @RequestBody String entity)
            throws JsonMappingException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(entity);
        String phone = node.get("phone").asText();
        String password = node.get("password").asText();
        String captcha = node.get("captcha").asText();

        if (phone == null || password == null || captcha == null) {
            return Result.error("请求参数错误");
        }

        if (phone.isBlank() || password.isBlank() || captcha.isBlank()) {
            return Result.error("请求参数错误");
        }

        // 校验验证码
        String code = (String) session.getAttribute(CAPTCHA_SESSION_KEY);
        if (!captcha.equalsIgnoreCase(code)) {
            return Result.error("验证码错误");
        }

        try {
            accountService.login(phone, password, captcha);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }

        return Result.success();
    }

}
