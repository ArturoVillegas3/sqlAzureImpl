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
public class Student {
    @Id
    @GeneratedValue
    private Integer idstudent;
    private String studentname;
    private String studentnumber;

    //Propiedades
    public Integer getIdstudent() {return idstudent;}

    public void setIdstudent(Integer idstudent) {
        this.idstudent = idstudent;
    }
    public String getStudentnumber() {
        return studentnumber;
    }
    public void setStudentnumber(String studentnumber) {
        this.studentnumber = studentnumber;
    }
    public String getStudentname() {
        return studentname;
    }
    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idstudent=" + idstudent +
                ", studentname='" + studentname + '\'' +
                ", studentnumber='" + studentnumber + '\'' +
                '}';
    }
}
