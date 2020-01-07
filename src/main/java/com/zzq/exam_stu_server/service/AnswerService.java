package com.zzq.exam_stu_server.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzq.exam_stu_server.domain.dao.ExamItemsMapper;
import com.zzq.exam_stu_server.domain.dao.UserMapper;
import com.zzq.exam_stu_server.domain.entity.ExamItems;
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
                // TODO 接收附件
                .enclosure(null)
                .build();
        if(examItemsMapper.insertSelective(examItems) < 0){
            return new JsonBean(-1,"Error：提交失败！",null);
        }
        return new JsonBean(0,"考试完成！",null);
    }
}
