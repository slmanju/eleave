package com.manjula.eleave.employee.service;

import com.manjula.eleave.employee.view.EmployeeView;

import java.util.List;

public interface EmployeeService {
    
    List<EmployeeView> findAll();

    void save(EmployeeView employee);
    
    EmployeeView findById(String id);

}
