package com.connectPostgres.demoPostgres.Service.Impl;

import com.connectPostgres.demoPostgres.Entity.LibraryLoan;
import com.connectPostgres.demoPostgres.Repository.LibraryLoanRepository;
import com.connectPostgres.demoPostgres.Service.LibraryLoanService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibraryLoanImpl implements LibraryLoanService {
    private LibraryLoanRepository libraryLoanRepository;

    public LibraryLoanImpl(LibraryLoanRepository libraryLoanRepository) {
        super();
        this.libraryLoanRepository = libraryLoanRepository;
    }
    @Override
    public List<LibraryLoan> getAllLibraryLoans(){
        return libraryLoanRepository.findAll();
    }
    @Override
    public LibraryLoan SaveLibraryLoan(LibraryLoan libraryLoan){
        return libraryLoanRepository.save(libraryLoan);
    }
    @Override
    public LibraryLoan GetLibraryLoanById(Integer id){
        return libraryLoanRepository.findById(id).get();
    }
    @Override
    public LibraryLoan EditLibraryLoan(LibraryLoan libraryLoan){
        return libraryLoanRepository.save(libraryLoan);
    }
    @Override
    public void deleteLibraryLoan(Integer id){
        libraryLoanRepository.deleteById(id);
    }
}
