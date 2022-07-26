package com.lyk.demo.service;

import com.lyk.demo.vo.req.StudentReqVO;
import com.lyk.demo.vo.res.StudentResVO;

import java.util.List;

public interface TestService {


    List<StudentResVO> queryAllStudents();

    List<StudentResVO> queryByClasses(StudentReqVO studentReqVO);
}
