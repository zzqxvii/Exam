package com.zzq.exam_stu_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zzq.exam_stu_server.domain.dao")
@SpringBootApplication
public class ExamStuServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamStuServerApplication.class, args);
    }

}
