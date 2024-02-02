package com.imaginnovate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imaginnovate.model.StudentMarks;

@Repository
public interface StudentMarksRepo  extends JpaRepository<StudentMarks, Integer>{

}
