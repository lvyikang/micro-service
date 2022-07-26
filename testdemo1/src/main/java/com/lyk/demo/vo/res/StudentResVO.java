package com.lyk.demo.vo.res;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 学生信息前端响应类
 */
@Data
@ApiModel(value = "响应前端学生类",description = "响应前端学生信息")
public class StudentResVO {

    private String name;

    private String classes;

    private String gender;

    private Integer age;
}
