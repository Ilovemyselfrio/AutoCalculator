package com.itherma.springbootquickstart.converter;

import com.itherma.springbootquickstart.dao.Student;
import com.itherma.springbootquickstart.dto.StudentDto;

public class StudentConverter {
    public static StudentDto convertStudent(Student student){
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        return studentDto;
    }
    public static Student convertStudent(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
//        age studentDto里还没有设置 先不用管
        return student;
    }
}
