package com.imaginnovate.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.imaginnovate.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
 @Query(value="SELECT * FROM STUDENT WHERE CLASS=?" ,nativeQuery=true)
  List<Student> findByClass(int standard);
 @Query(value="SELECT * FROM STUDENT WHERE AGE BETWEEN ? AND ?" ,nativeQuery=true)
 		
List<Student> findByAge(int startAge, int endAge);
 
}
