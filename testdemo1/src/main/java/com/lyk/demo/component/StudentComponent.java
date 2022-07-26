package com.lyk.demo.component;

import com.lyk.demo.dataDo.StudentDO;
import com.lyk.demo.vo.req.StudentReqVO;

import java.util.List;

public interface StudentComponent {

    List<StudentDO> queryAllStudents();

    List<StudentDO> queryByClasses(StudentReqVO studentReqVO);
}
