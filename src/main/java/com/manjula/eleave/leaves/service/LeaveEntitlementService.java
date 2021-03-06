package com.manjula.eleave.leaves.service;

import com.manjula.eleave.leaves.view.LeaveEntitlementView;

import java.util.List;

public interface LeaveEntitlementService {

    void saveAllForYear(int year);

    void save(LeaveEntitlementView leaveEntitlementView);

    List<LeaveEntitlementView> findByEmployee(String employeeId);

}
