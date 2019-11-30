package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

public class HomeController {
    @Autowired
    StudentRepository studentRepository;
            @Autowired
    CourseRepository courseRepository;
            @RequestMapping("/")
    public String index(Model model){
                Course course = new Course();
                course.setTitle("History");
                course.setCredit(3);

                Student student = new Student();
                student.setFirstName("Brianna");
                student.setLastName("Plowright");

                course.setDescription("American History");
                Set <Course> courseSet = new HashSet<Course>();
                courseSet.add(course);
                student.setCourseSet(courseSet);
                studentRepository.save(student);
                model.addAttribute("studentSet",studentRepository.findAll());
                return "index";
            }
}
