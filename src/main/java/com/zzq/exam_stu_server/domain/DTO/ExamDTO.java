package com.zzq.exam_stu_server.domain.DTO;

import com.zzq.exam_stu_server.domain.entity.TestTitle;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO {

    private Integer id;

    private Integer pattern;

    private Integer monitor;

    private Integer timeLength;

    private List<TestTitle> testTitleList;
}
