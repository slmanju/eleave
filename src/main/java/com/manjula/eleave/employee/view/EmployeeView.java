package com.manjula.eleave.employee.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeView {

    private String id;
    private String firstName;
    private String lastName;
    private String email;

}
