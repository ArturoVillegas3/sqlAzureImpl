package com.connectPostgres.demoPostgres.Controller;

import com.connectPostgres.demoPostgres.Entity.Book;
import com.connectPostgres.demoPostgres.Service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        super();
        this.bookService = bookService;
    }

    //Index
    @GetMapping("/books")
    public String listBooks(Model model){
        model.addAttribute("books",bookService.getAllBooks());
        return "books";
    }

    //Create
    @GetMapping("/books/new")
    public String CreateBook(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return "create_book";
    }

    //Handle create
    @PostMapping("/books")
    public String SaveBooks(@ModelAttribute("book") Book book){
        bookService.SaveBook(book);
        return "redirect:/books";
    }

    //Edit
    @GetMapping("/books/edit/{id}")
    public String EditBook(@PathVariable Integer id, Model model){
        model.addAttribute("book", bookService.GetBookById(id));
        return "edit_book";
    }

    //Handle Edit
    @PostMapping("/books/{id}")
    public String updateBook(@PathVariable Integer id,
                                @ModelAttribute("book") Book book,
                                Model model){
        //obtiene book de la bd
        Book editBook = bookService.GetBookById(id);
        editBook.setBookname(book.getBookname());
        editBook.setIsborrowed(book.getIsborrowed());

        //se guarda
        bookService.EditBook(editBook);
        return "redirect:/books";
    }

    //Delete
    @GetMapping("/books/{id}")
    public String deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
