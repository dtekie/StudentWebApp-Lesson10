//package edu.miu.cs.cs425.studentwebapp.controller;
//
//import edu.miu.cs.cs425.studentwebapp.model.Student;
//import edu.miu.cs.cs425.studentwebapp.service.StudentService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping(value = {"/sysadmin/student"})
//public class StudentController {
//
//    @Autowired
//    private StudentService studentService;
//
//
//    @GetMapping(value = {"/list"})
//    public String listStudents(Model model) {
//        var students = studentService.getALlStudents();
//        model.addAttribute("students", students);
//        return "sysadmin/student/list";
//    }
//
//    @GetMapping(value = {"/list2"})
//    public ModelAndView listStudents2() {
//        var students = studentService.getALlStudents();
//        var modelAndView = new ModelAndView();
//        modelAndView.addObject("students", students);
//        modelAndView.setViewName("sysadmin/student/list");
//        return modelAndView;
//    }
//
//    @GetMapping(value = "/new")
//    public String displayNewStudentForm(Model model) {
//        var student = new Student();
//        model.addAttribute("student", student);
//        return "sysadmin/student/new";
//    }
//
//    @PostMapping(value = "/new")
//    public String addNewStudent(@Valid @ModelAttribute("student") Student newStudent,
//                                  BindingResult bindingResult, Model model) {
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "sysadmin/student/new";
//        }
//        studentService.addNewStudent(newStudent);
//        return "redirect:/sysadmin/student/list2";
//    }
//
//    @GetMapping(value = {"/edit/{studentId}"})
//    public String editStudent(@PathVariable Long studentId, Model model) {
//        var student = studentService.getStudentById(studentId);
//        if(student != null) {
//            model.addAttribute("student", student);
//            return "sysadmin/student/edit";
//        }
//        return "redirect:/sysadmin/student/list";
//    }
//
//    @PostMapping(value = {"/update"})
//    public String updatedStudent(@Valid @ModelAttribute("student") Student student,
//                                  BindingResult bindingResult, Model model) {
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("student", student);
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "sysadmin/student/edit";
//        }
//        studentService.updateStudent(student);
//        return "redirect:/sysadmin/student/list";
//    }
//
package edu.miu.cs.cs425.studentwebapp.controller;

import edu.miu.cs.cs425.studentwebapp.model.Student;
import edu.miu.cs.cs425.studentwebapp.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/sysadmin/student"})
public class StudentController {
    @Autowired
    StudentService studentService;
//    @GetMapping(value = {"/home","/"})
//    public String displayHome(){
//        return "public/index";
//    }
    @GetMapping(value = "/list")
    public ModelAndView displayListOfStudent(){
        var modelAndView=new ModelAndView();
        var student=studentService.getALlStudents();
        modelAndView.addObject("fetchedStudent",student);
        modelAndView.setViewName("sysadmin/student/list");
        return modelAndView;
    }

    @GetMapping(value={"/new"})
    public String displayAddingPage(Model model){
        model.addAttribute("student",new Student());
        return "sysadmin/student/new";
    }
    @PostMapping(value={"/new"})
    public String addStudent(@Valid @ModelAttribute("student")Student student,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("student",student);
            model.addAttribute("error",result.getAllErrors());
            return "sysadmin/student/list";
        }

        studentService.addNewStudent(student);
        return "redirect:/sysadmin/student/list";
    }

    //Delete

    @GetMapping(value = {"/delete/{studentId}"})
    public String deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/sysadmin/student/list";
    }

    //Editing

    @GetMapping(value = {"/edit/{studentId}"})
    public String editStudent(@PathVariable Long studentId, Model model) {
        var student = studentService.getStudentById(studentId);
        if(student != null) {
            model.addAttribute("student", student);
            return "sysadmin/student/update";
        }
        return "redirect:/sysadmin/student/list";
    }

    @PostMapping(value = {"/update/{studentId}"})
    public String updateStudent(@Valid @ModelAttribute("studentId") Student student,
                                BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "sysadmin/student/update";
        }
        var studentSaved= studentService.updateStudent(student);
        System.out.println(studentSaved);
        return "redirect:/sysadmin/student/list";
    }

    @GetMapping(value = {"/searchview"})
    public String displaySearch(){
        return "sysadmin/searched/search";
    }


    @GetMapping(value = {"/search"})
    public ModelAndView searchStudent(@RequestParam String searchString) {
        var modelAndView = new ModelAndView();
        var student = studentService.findStudentByName(searchString);
        modelAndView.addObject("student", student);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("sysadmin/searched/search");
        return modelAndView;
    }
}


