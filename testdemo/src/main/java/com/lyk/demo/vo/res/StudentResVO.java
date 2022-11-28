package com.lyk.demo.vo.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 学生信息前端响应类
 */
@Data
@ApiModel(value = "响应前端学生类",description = "响应前端学生信息")
public class StudentResVO {

    @ApiModelProperty(value = "学生表主键", example = "111")
    private Long id;

    @ApiModelProperty(value = "姓名", example = "张三")
    private String name;

    @ApiModelProperty(value = "班级", example = "九年1班")
    private String classes;

    @ApiModelProperty(value = "性别", example = "F")
    private String gender;

    @ApiModelProperty(value = "年龄", example = "28")
    private Integer age;

    @ApiModelProperty(value = "学校", example = "一中")
    private String school;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

}
