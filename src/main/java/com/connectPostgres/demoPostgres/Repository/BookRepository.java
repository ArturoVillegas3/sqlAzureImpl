package com.connectPostgres.demoPostgres.Repository;

import com.connectPostgres.demoPostgres.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer>{
}
