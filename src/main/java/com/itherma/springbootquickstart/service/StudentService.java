package com.itherma.springbootquickstart.service;

import com.itherma.springbootquickstart.dto.StudentDto;

public interface StudentService {
//    根据student的ID来查询具体的student
    StudentDto getStudentById(long id);

    Long addNewStudent(StudentDto studentDto);

    void deleteStudentByID(long id);

    StudentDto updateStudentById(long id, String name, String email);
//    批量查询谁的数据 可能用到分页 ，也是在此处写方法
}
