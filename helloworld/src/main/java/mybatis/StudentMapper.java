package mybatis;


import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by majun on 15/9/10.
 */
public interface StudentMapper {
    Student selectStudent(int id);

    @Select("select * from elestudent where id=#{id}")
    Student selectStudent2(int id);

    void insertStudents(List<Student> studentList);
}
