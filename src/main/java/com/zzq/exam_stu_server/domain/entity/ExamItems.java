package com.zzq.exam_stu_server.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * exam_items
 * @author 
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamItems implements Serializable {
    private Integer id;

    private Integer examId;

    private Integer userId;

    /**
     * 答案
     */
    private String answer;

    /**
     * 附件
     */
    private String enclosure;

    private static final long serialVersionUID = 1L;
}