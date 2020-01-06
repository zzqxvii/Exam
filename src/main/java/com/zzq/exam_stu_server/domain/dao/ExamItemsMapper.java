package com.zzq.exam_stu_server.domain.dao;

import com.zzq.exam_stu_server.domain.entity.ExamItems;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamItemsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ExamItems record);

    int insertSelective(ExamItems record);

    ExamItems selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExamItems record);

    int updateByPrimaryKey(ExamItems record);
}