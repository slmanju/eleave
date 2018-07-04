package com.manjula.eleave.employee.controller;

import com.manjula.eleave.employee.service.EmployeeService;
import com.manjula.eleave.employee.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    
    @GetMapping(value = "")
    public String index(ModelMap modelMap) {
        List<EmployeeView> employees = employeeService.findAll();
        modelMap.addAttribute("employees", employees);
        return "employee/employees";
    }
    
    @GetMapping(value = "/add")
    public String addForm(ModelMap modelMap) {
        modelMap.addAttribute("employee", new EmployeeView());
        return "employee/employee-add";
    }

    @PostMapping(value = "/add")
    public String add(EmployeeView employee, ModelMap modelMap) {
        employeeService.save(employee);
        modelMap.addAttribute("employee", employee);
        modelMap.addAttribute("message", "Employee Added");
        return "employee/employee-add";
    }
    
    @GetMapping(value = "/update")
    public String updateForm(String id, ModelMap modelMap) {
        EmployeeView employeeView = employeeService.findById(id);
        modelMap.addAttribute("employee", employeeView);
        return "employee/employee-update";
    }
    
    @PostMapping(value = "/update")
    public String update(EmployeeView employee, ModelMap modelMap) {
        employeeService.update(employee);
        modelMap.addAttribute("employee", employee);
        modelMap.addAttribute("message", "Employee Updated");
        return "employee/employee-update";
    }
    
    @GetMapping(value = "/view")
    public String view(@RequestParam String id, ModelMap modelMap) {
        EmployeeView employeeView = employeeService.findById(id);
        modelMap.addAttribute("employee", employeeView);
        return "employee/employee-view";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam String id, ModelMap modelMap) {
        employeeService.delete(id);
        return "redirect:/employee";
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
}
