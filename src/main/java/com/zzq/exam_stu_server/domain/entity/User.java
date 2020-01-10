package com.zzq.exam_stu_server.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * user
 * @author zzq
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    /**
     * -1：管理员，0：学生，1：老师
     */
    private Integer role;

    private String tel;

    private static final long serialVersionUID = 1L;
}