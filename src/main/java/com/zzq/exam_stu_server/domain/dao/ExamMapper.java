package com.zzq.exam_stu_server.domain.dao;

import com.zzq.exam_stu_server.domain.entity.Exam;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);
}