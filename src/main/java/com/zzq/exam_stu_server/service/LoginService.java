package com.zzq.exam_stu_server.service;

import com.zzq.exam_stu_server.domain.dao.UserMapper;
import com.zzq.exam_stu_server.util.JsonBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private UserMapper mapper;

    public JsonBean login(HttpServletRequest httpServletRequest, String username, String password){
        if (username == null || username.isEmpty()) return new JsonBean(-1,"用户名不能为空",null);
        if (password == null || password.isEmpty()) return new JsonBean(-1,"密码不能为空",null);
        if (mapper.selectByUsername(username) == null) return new JsonBean(-1,"用户不存在",null);
        if (mapper.selectByUsername(username).getPassword().equals(password)) {

            HttpSession session = httpServletRequest.getSession(true);
            session.setAttribute("username",username);
            log.info("session info[{}]",session.getId());
            // TODO  data：试卷ID
            return new JsonBean(0, "登录成功", 3);
        }
        else
            return new JsonBean(-1,"密码错误",null);
    }
}
