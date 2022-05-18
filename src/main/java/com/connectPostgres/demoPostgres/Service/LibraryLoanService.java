package com.connectPostgres.demoPostgres.Service;
import com.connectPostgres.demoPostgres.Entity.LibraryLoan;

import java.util.List;
public interface LibraryLoanService {
    List<LibraryLoan> getAllLibraryLoans();
    LibraryLoan SaveLibraryLoan(LibraryLoan libraryLoan);
    LibraryLoan GetLibraryLoanById(Integer id);
    LibraryLoan EditLibraryLoan(LibraryLoan libraryLoan);
    void deleteLibraryLoan(Integer id);
}
