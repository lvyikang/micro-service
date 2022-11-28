package com.lyk.demo.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 前端查询学生请求参数
 */
@Data
@ApiModel("响应前端学生类")
public class StudentReqVO {

    @ApiModelProperty(value = "姓名", example = "张三")
    private String name;

    @ApiModelProperty(value = "班级", example = "九年1班")
    private String classes;

    @ApiModelProperty(value = "性别", example = "F")
    private String gender;

    @ApiModelProperty(value = "年龄", example = "28")
    private Integer age;
}
