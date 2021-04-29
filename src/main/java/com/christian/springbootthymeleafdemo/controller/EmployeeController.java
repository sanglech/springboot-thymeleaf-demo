package com.christian.springbootthymeleafdemo.controller;

import com.christian.springbootthymeleafdemo.model.Employee;
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
    private List<Employee> employees;

    @PostConstruct
    private void loadData(){
        //create employees
        Employee empl1= new Employee(1,"Bob","Doe","bob@doe.com");
        Employee empl2= new Employee(1,"Scott","scotty","scott@scotty.com");
        Employee empl3= new Employee(1,"cat","cat","cat@cat.com");
        Employee empl4= new Employee(1,"dog","dog","dog@dog.com");
        //create list

        employees= new ArrayList<>();
        //add to the list
        employees.add(empl1);
        employees.add(empl2);
        employees.add(empl3);
        employees.add(empl4);

    }

    //addmapping for /list

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("theEmployees",employees);

        return "list-employees";
    }
}
