package com.christian.springbootthymeleafdemo.controller;

import com.christian.springbootthymeleafdemo.entity.Employee;
import com.christian.springbootthymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        //create model attribute to bind form data
        Employee theEmplyee = new Employee();

        theModel.addAttribute("employee",theEmplyee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){
        //get employee from the service
        Employee theEmployee = employeeService.getEmployeeById(theId);

        //prepopulate model

        theModel.addAttribute("employee",theEmployee);

        //send to our form page
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        //save the employee
        employeeService.saveEmployee(theEmployee);
        //use redirect to rpevent multple saves
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
        //get employee from the service
        Employee theEmployee = employeeService.getEmployeeById(theId);

        //prepopulate model
        if(theEmployee==null){
            throw new RuntimeException("Employee with the id: "+ theId+ " does not exist");
        }
        employeeService.deleteEmployeeById(theId);

        //redirect back to list
        return "redirect:/employees/list";
    }
}
