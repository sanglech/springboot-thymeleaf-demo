package com.christian.springbootthymeleafdemo.controller;

import com.christian.springbootthymeleafdemo.entity.Employee;
import com.christian.springbootthymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    //load employee data
    private EmployeeService employeeService;

    @Autowired
     public EmployeeController (EmployeeService theEmployeeService){
         employeeService= theEmployeeService;
     }

    //addmapping for /list
    @GetMapping("/list")
    public String listEmployees(Model theModel){

        //Get employees from db
        List<Employee> employees= employeeService.findAll();

        theModel.addAttribute("theEmployees",employees);

        return "list-employees";
    }
}
