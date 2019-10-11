package com.tinmegali.springdatamongodbmultitenant.controller;

import com.tinmegali.springdatamongodbmultitenant.model.Person;
import com.tinmegali.springdatamongodbmultitenant.service.PersonService;
import com.tinmegali.springdatamongodbmultitenant.config.security.MockUserDetailsService;
import com.tinmegali.springdatamongodbmultitenant.config.security.CustomUsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    MockUserDetailsService mockUserDetailsService;

    @Autowired
    PersonService personService;

    @GetMapping("/hello")
    public String getHello(Model model) {
        CustomUsernamePasswordToken authentication = (CustomUsernamePasswordToken) SecurityContextHolder.getContext().getAuthentication();
        // username
        model.addAttribute("user", authentication.getPrincipal());
        // tenant information to model
        model.addAttribute("tenant", authentication.getTenant());

        // list data
        List<Person> data = personService.getAll();
        model.addAttribute("persons", data);
        return "hello";
    }

}
