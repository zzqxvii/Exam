package com.zzq.exam_stu_server.service;

import com.zzq.exam_stu_server.domain.dao.UserMapper;
import com.zzq.exam_stu_server.domain.entity.User;
import com.zzq.exam_stu_server.util.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserMapper mapper;

    public JsonBean userRegister(User user){
        if(user.getUsername() == null || user.getUsername().isEmpty()) return new JsonBean(-1,"用户名不能为空",null);
        if(user.getUsername().length() < 3) return new JsonBean(-1,"用户名过短",null);
        if(user.getPassword() == null || user.getPassword().isEmpty()) return new JsonBean(-1,"密码不能为空",null);
        if(user.getPassword().length() < 6) return new JsonBean(-1,"密码过短",null);
        if(user.getTel() == null || user.getTel().isEmpty()) return new JsonBean(-1,"手机号不能为空",null);
        if(user.getTel().length() > 11) return new JsonBean(-1,"你手机号这么长？",null);

        if (mapper.selectByUsername(user.getUsername()) == null) {
            if (mapper.insertSelective(user) > 0) {
                return new JsonBean(0,"注册成功",null);
            } else {
                return new JsonBean(-1,"注册失败",null);
            }
        } else {
            return new JsonBean(-1,"用户名已存在",null);
        }
    }
}
