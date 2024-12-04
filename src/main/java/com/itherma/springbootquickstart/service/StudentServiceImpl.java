package com.itherma.springbootquickstart.service;

import com.itherma.springbootquickstart.converter.StudentConverter;
import com.itherma.springbootquickstart.dao.Student;
import com.itherma.springbootquickstart.dao.StudentRepository;
import com.itherma.springbootquickstart.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired//实现注入 注入studentRepository 我们才可以去使用
    private StudentRepository studentRepository;
    @Override
    public StudentDto getStudentById(long id) {
//        //findById 父接口提供的方法
//        return studentRepository.findById(id).orElseThrow(RuntimeException::new);//如果不存在则抛出异常！
          Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
//          做个convert 转换
        return StudentConverter.convertStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDto studentDto) {
        List<Student> studentList = studentRepository.findByEmail(studentDto.getEmail());
//        判断是否重复
        if(!CollectionUtils.isEmpty(studentList)){
//      存在相同邮箱的学生
            throw new IllegalStateException("email:" + studentDto.getEmail() + "has been taken");
        }
//        把我们的Dto（Data transfer Object 是一个简单的Java Bean，用于在应用程序的不同层之间传输数据，
//        通常用于接收来自客户端的数据） 对象转换为数据库的对象
//        将一个 StudentDto 对象转换为 Student 实体，
//        然后通过 studentRepository 的 .save() 方法将其保存到数据库中。这个过程通常发生在处理HTTP请求，如添加新学生信息到数据库时。
        Student student = studentRepository.save(StudentConverter.convertStudent(studentDto));
        return student.getId();

    }

    @Override
    public void deleteStudentByID(long id) {
//        删除前判断 用户的 id 存不存在
        studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id:" + id + "doesn't exist!"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDto updateStudentById(long id, String name, String email) {
//        首先检查id是否存在
        Student studentInDB = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("id:" + id + "doesn't exist!"));
//        再检查name是否为空，并且与数据库中对应的name不一致 我们才更新
        if(StringUtils.hasLength(name) && !studentInDB.getName().equals(name)) {
            studentInDB.setName(name);
        }
//        同理检查邮件
        if(StringUtils.hasLength(email) && !studentInDB.getEmail().equals(email)) {
            studentInDB.setEmail(email);
        }
//        最后保存更改 到数据库中
        Student student = studentRepository.save(studentInDB);
//        把更新完之后的 student返回给前端，故需转换！
        return StudentConverter.convertStudent(student);
    }
}
