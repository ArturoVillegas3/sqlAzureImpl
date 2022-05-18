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
public class Book {
    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Boolean getIsborrowed() {
        return isborrowed;
    }

    public void setIsborrowed(Boolean isborrowed) {
        this.isborrowed = isborrowed;
    }

    @Id
    @GeneratedValue
    public Integer bookid;
    public String bookname;
    public Boolean isborrowed;
}
