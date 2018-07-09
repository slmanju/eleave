package com.manjula.eleave.leaves.view;

import com.manjula.eleave.employee.view.EmployeeView;
import com.manjula.eleave.leaves.model.LeaveStatus;
import com.manjula.eleave.leaves.model.LeaveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveView {

    private String id;
    private EmployeeView employee;
    private LeaveType type;
    private Date fromDate;
    private Date toDate;
    private String comment;
    private LeaveStatus status = LeaveStatus.PENDING;

}
