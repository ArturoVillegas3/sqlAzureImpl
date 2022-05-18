package com.connectPostgres.demoPostgres.Controller;

import com.connectPostgres.demoPostgres.Entity.LibraryLoan;
import com.connectPostgres.demoPostgres.Service.BookService;
import com.connectPostgres.demoPostgres.Service.LibraryLoanService;
import com.connectPostgres.demoPostgres.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibraryLoanController {
    private LibraryLoanService libraryLoanService;
    private BookService bookService;
    private StudentService studentService;

    public LibraryLoanController(LibraryLoanService libraryLoanService, BookService bookService, StudentService studentService) {
        super();
        this.libraryLoanService = libraryLoanService;
        this.bookService = bookService;
        this.studentService = studentService;
    }
    //Index
    @GetMapping("/libraryloans")
    public String listStudents(Model model) {
        model.addAttribute("libraryloans",libraryLoanService.getAllLibraryLoans());

        return "libraryloans";
    }
    //Create
    @GetMapping("/libraryloans/new")
    public String Createlibraryloan(Model model){
        LibraryLoan libraryLoan = new LibraryLoan();
        model.addAttribute("libraryLoan",libraryLoan);
        return "create_libraryloan";
    }

    //Handle create
    @PostMapping("/libraryloans")
    public String Savelibraryloan(@ModelAttribute("libraryLoan") LibraryLoan libraryLoan){
        libraryLoan.bookname = bookService.GetBookById(libraryLoan.getBookid()).getBookname();
        libraryLoan.studentname = studentService.GetStudentById(libraryLoan.getStudentid()).getStudentname();
        libraryLoanService.SaveLibraryLoan(libraryLoan);
        return "redirect:/libraryloans";
    }

    //Edit
    @GetMapping("/libraryloans/edit/{id}")
    public String EditLibraryLoan(@PathVariable Integer id, Model model){
        model.addAttribute("libraryLoan", libraryLoanService.GetLibraryLoanById(id));
        return "edit_libraryloans";
    }

    //Handle Edit
    @PostMapping("/libraryloans/{id}")
    public String updateLibraryLoan(@PathVariable Integer id,
                             @ModelAttribute("libraryLoan") LibraryLoan libraryLoan,
                             Model model){
        //obtiene el loan de la bd
        LibraryLoan editLoan = libraryLoanService.GetLibraryLoanById(id);
        editLoan.setBookid(libraryLoan.getBookid());
        editLoan.setStudentid(libraryLoan.getStudentid());
        editLoan.setStudentName(studentService.GetStudentById(libraryLoan.getStudentid()).getStudentname());
        editLoan.setBookName(bookService.GetBookById(libraryLoan.getBookid()).getBookname());

        //se guarda
        libraryLoanService.EditLibraryLoan(editLoan);
        return "redirect:/libraryloans";
    }

    //Delete
    @GetMapping("/libraryloans/{id}")
    public String deleteLibraryLoan(@PathVariable Integer id){
        libraryLoanService.deleteLibraryLoan(id);
        return "redirect:/libraryloans";
    }
}
