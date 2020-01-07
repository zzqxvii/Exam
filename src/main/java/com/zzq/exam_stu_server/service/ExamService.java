package com.zzq.exam_stu_server.service;

import com.zzq.exam_stu_server.domain.DTO.ExamDTO;
import com.zzq.exam_stu_server.domain.dao.ExamMapper;
import com.zzq.exam_stu_server.domain.dao.TestTitleMapper;
import com.zzq.exam_stu_server.domain.entity.Exam;
import com.zzq.exam_stu_server.domain.entity.TestTitle;
import com.zzq.exam_stu_server.util.JsonBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private TestTitleMapper testTitleMapper;

    public JsonBean getPaper(Integer examId){

        Exam exam =  examMapper.selectByPrimaryKey(examId);

        String[] testTitles = exam.getTestid().split(",");

        List<TestTitle> testTitleList = new ArrayList<>();
        TestTitle testTitle = null;

        for (String id: testTitles) {
            testTitle = testTitleMapper.selectByPrimaryKey(Integer.parseInt(id));
            testTitle.setAnswer(null);
            testTitleList.add(testTitle);
        }

        // 按类型排序 1.选择 2.判断 3.填空 4.简答
        Collections.sort(testTitleList, new Comparator<TestTitle>() {
            @Override
            public int compare(TestTitle o1, TestTitle o2) {
                int i = o1.getType() - o2.getType();
                if (i == 0){
                    return o1.getType()-o2.getType();
                }
                return i;
            }
        });

        ExamDTO examDTO = ExamDTO.builder()
                .id(exam.getId())
                .monitor(exam.getMonitor())
                .pattern(exam.getPattern())
                .timeLength(exam.getTimeLength())
                .testTitleList(testTitleList)
                .build();

        return new JsonBean(0,"",examDTO);
    }
}
