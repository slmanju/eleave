package com.manjula.eleave.employee.model;

import com.manjula.eleave.employee.view.EmployeeView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "employee")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    
    public static Employee valueOf(EmployeeView view) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(view, employee);
        return employee;
    }

    public EmployeeView view() {
        EmployeeView view = new EmployeeView();
        BeanUtils.copyProperties(this, view);
        return view;
    }
    
    public static List<EmployeeView> views(List<Employee> employees) {
        return employees.stream().map(Employee::view).collect(Collectors.toList());
    }

}
