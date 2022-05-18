package com.connectPostgres.demoPostgres.Controller;

import com.connectPostgres.demoPostgres.Entity.Student;
import com.connectPostgres.demoPostgres.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //Index
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

    //Create
    @GetMapping("/students/new")
    public String CreateStudent(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    //Handle create
    @PostMapping("/students")
    public String SaveStudent(@ModelAttribute("student") Student student){
        studentService.SaveStudent(student);
        return "redirect:/students";
    }

    //Edit
    @GetMapping("/students/edit/{id}")
    public String EditStudent(@PathVariable Integer id, Model model){
        model.addAttribute("student", studentService.GetStudentById(id));
        return "edit_student";
    }

    //Handle Edit
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Integer id,
        @ModelAttribute("student") Student student,
        Model model){
        //obtiene student de la bd
        Student editStudent = studentService.GetStudentById(id);
        editStudent.setStudentname(student.getStudentname());
        editStudent.setStudentnumber(student.getStudentnumber());

        //se guarda
        studentService.EditStudent(editStudent);
        return "redirect:/students";
    }

    //Detele
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}