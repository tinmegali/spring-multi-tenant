package com.tinmegali.springdatamongodbmultitenant.controller;

import com.tinmegali.springdatamongodbmultitenant.model.Person;
import com.tinmegali.springdatamongodbmultitenant.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/add-person")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return "PersonNew";
    }

    @PostMapping("/add-person")
    public RedirectView postPerson(@ModelAttribute Person person) {
        personService.addPerson(person);
        return new RedirectView("hello");
    }

}
