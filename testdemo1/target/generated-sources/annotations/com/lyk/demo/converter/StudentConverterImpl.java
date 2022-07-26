package com.lyk.demo.converter;

import com.lyk.demo.dataDo.StudentDO;
import com.lyk.demo.vo.res.StudentResVO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-26T10:44:18+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 1.8.0_333 (Oracle Corporation)"
)
public class StudentConverterImpl implements StudentConverter {

    @Override
    public StudentResVO doToResVO(StudentDO studentDO) {
        if ( studentDO == null ) {
            return null;
        }

        StudentResVO studentResVO = new StudentResVO();

        studentResVO.setName( studentDO.getName() );
        studentResVO.setClasses( studentDO.getClasses() );
        studentResVO.setGender( studentDO.getGender() );
        studentResVO.setAge( studentDO.getAge() );

        return studentResVO;
    }
}
