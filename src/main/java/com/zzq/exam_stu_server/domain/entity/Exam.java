package com.zzq.exam_stu_server.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * exam
 * @author zzq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam implements Serializable {
    private Integer id;

    /**
     * 考试模式：1限通信，2霸屏
     */
    private Integer pattern;

    /**
     * 是否开启监控：0不开启，1开启
     */
    private Integer monitor;

    /**
     * 考题Id 逗号间隔
     */
    private String testid;

    /**
     * 考试时长 单位分钟
     */
    private Integer timeLength;

    private static final long serialVersionUID = 1L;
}