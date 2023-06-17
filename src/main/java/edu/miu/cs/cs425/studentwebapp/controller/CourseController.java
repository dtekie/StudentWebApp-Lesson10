package edu.miu.cs.cs425.studentwebapp.controller;


import edu.miu.cs.cs425.studentwebapp.model.Course;
import edu.miu.cs.cs425.studentwebapp.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/sysadmin/course"})
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping(value = {"/list"})
    public String listCourses(Model model) {
        var courses = courseService.getAllCourses();
        model.addAttribute("courses", courses);
        return "sysadmin/course/list";
    }

    @GetMapping(value = {"/list2"})
    public ModelAndView listCourses2() {
        var courses = courseService.addNewCourse(new Course());
        var modelAndView = new ModelAndView();
        modelAndView.addObject("courses", courses);
        modelAndView.setViewName("sysadmin/course/list");
        return modelAndView;
    }

    @GetMapping(value = "/new")
    public String displayNewStudentForm(Model model) {
        var course = new Course();
        model.addAttribute("course", course);
        return "sysadmin/course/new";
    }

    @PostMapping(value = "/new")
    public String addNewStudent(@Valid @ModelAttribute("course") Course newCourse,
                                  BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "sysadmin/course/new";
        }
        courseService.addNewCourse(newCourse);
        return "redirect:/sysadmin/course/list2";
    }

}
