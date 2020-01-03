package com.zzq.exam_stu_server.util;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JsonBean {
    int code;
    String msg;
    Object data;
}
