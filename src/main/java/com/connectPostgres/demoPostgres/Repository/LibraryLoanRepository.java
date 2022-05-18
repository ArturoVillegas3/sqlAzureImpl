package com.connectPostgres.demoPostgres.Repository;

import com.connectPostgres.demoPostgres.Entity.LibraryLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryLoanRepository extends JpaRepository<LibraryLoan,Integer> {
}
