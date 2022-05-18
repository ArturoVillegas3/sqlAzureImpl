package com.connectPostgres.demoPostgres.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryLoan {
    @Id
    @GeneratedValue
    private Integer loanid;
    private Integer studentid;
    private Integer bookid;
    public String studentname;
    public String bookname;

    public String getBookName() {
        return bookname;
    }

    public void setBookName(String bookName) {
        this.bookname = bookName;
    }

    public String getStudentName() {
        return studentname;
    }

    public void setStudentName(String studentName) {
        this.studentname = studentName;
    }

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }
}
