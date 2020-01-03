package com.zzq.exam_stu_server.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * test_title
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestTitle implements Serializable {
    private Integer id;

    private Integer type;

    private String title;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private String answer;

    private static final long serialVersionUID = 1L;
}