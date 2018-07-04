package com.manjula.eleave.employee.service.impl;

import com.manjula.eleave.employee.model.Employee;
import com.manjula.eleave.employee.repository.EmployeeRepository;
import com.manjula.eleave.employee.service.EmployeeService;
import com.manjula.eleave.employee.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeView> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        return Employee.views(employees);
    }

    @Override
    public void save(EmployeeView employee) {
        employeeRepository.save(Employee.valueOf(employee));
    }

    @Override
    public void update(EmployeeView employee) {
        employeeRepository.save(Employee.valueOf(employee));
    }

    @Override
    public EmployeeView findById(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(Employee::view).orElse(null);
    }

    @Override
    public void delete(String id) {
        employeeRepository.deleteById(id);
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

}
