package com.example.hibernate.controller;

import com.example.hibernate.entity.School;
import com.example.hibernate.repository.SchoolRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SchoolController {

    @Autowired
    private SchoolRepository repository;

    @GetMapping("/schools")
    public String getAll(Model model) {
        model.addAttribute("schools", repository.findAll());
        return "schools";
    }

    @GetMapping("/school")
    public String getSchool(Model model, @RequestParam(required = false) Long id) {

        School school = new School();
        if (id != null) {
            Optional<School> optionalSchool = repository.findById(id);
            if (optionalSchool.isPresent()) {
                school = optionalSchool.get();
            }
        }
        model.addAttribute("school", school);
        return "school";
    }

    @PostMapping("/school")
    public String postSchool(@RequestBody School school) {
        System.out.println(school.getId());
        System.out.println(school.getName());
        repository.save(school);
        return "redirect:/schools";
    }

    @GetMapping("/school/delete")
    public String deleteSchool(@RequestParam Long id) {
        repository.deleteById(id);
        return "redirect:/schools";
    }
}
