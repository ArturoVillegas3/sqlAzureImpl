package com.connectPostgres.demoPostgres.Repository;

import com.connectPostgres.demoPostgres.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
}
