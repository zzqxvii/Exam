package com.zzq.exam_stu_server.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzq.exam_stu_server.domain.dao.ExamItemsMapper;
import com.zzq.exam_stu_server.domain.dao.UserMapper;
import com.zzq.exam_stu_server.domain.entity.ExamItems;
import com.zzq.exam_stu_server.domain.entity.User;
import com.zzq.exam_stu_server.util.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private ExamItemsMapper examItemsMapper;
    @Autowired
    private UserMapper userMapper;

    public JsonBean getAnswer(String json){
        JSONObject jsonObject = JSON.parseObject(json);
        String answer = jsonObject.get("answer").toString();
        String username = jsonObject.get("username").toString();
        Integer examId = (Integer) jsonObject.get("examId");

        ExamItems examItems = ExamItems.builder()
                .examId(examId)
                .userId(userMapper.selectByUsername(username).getId())
                .answer(answer)
                .enclosure(null)
                .build();
        examItemsMapper.insertSelective(examItems);

        System.out.println(answer);
        System.out.println(examItems);

        return new JsonBean(0,"success",null);
    }
}
