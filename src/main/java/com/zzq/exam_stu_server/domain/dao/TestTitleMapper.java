package com.zzq.exam_stu_server.domain.dao;

import com.zzq.exam_stu_server.domain.entity.TestTitle;
import org.springframework.stereotype.Repository;

@Repository
public interface TestTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestTitle record);

    int insertSelective(TestTitle record);

    TestTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestTitle record);

    int updateByPrimaryKey(TestTitle record);
}