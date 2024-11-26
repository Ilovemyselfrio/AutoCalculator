package com.itherma.springbootquickstart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//JpaRepository<Student, Long>表示对数据库表映射到java的对象Student 主键是long类型
public interface StudentRepository extends JpaRepository<Student, Long> {
//    在JPA里，findBy...你按照他的字段方法 约定的配置的话，它会自动地根据email去查询数据，就不用去手写sql了
//    只有复杂的场景下需要去手写，比如findByEmailAndName......
    List<Student> findByEmail(String email);


}
