package com.manjula.eleave.employee.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.manjula.myleave.rbac.view.PrivilegeView;

public class PrivilegeViewFormatter implements Formatter<PrivilegeView> {

    @Override
    public String print(PrivilegeView object, Locale locale) {
        System.out.println("[PRINT:" + object.getId() + "]");
        return object.getId();
    }

    @Override
    public PrivilegeView parse(String id, Locale locale) throws ParseException {
        System.out.println("[PARSE:" + id + "]");
        if (id == null || id.isEmpty()) {
            throw new ParseException("Invalid format", -1);
        }
        PrivilegeView view = new PrivilegeView();
        view.setId(id);
        return view;
    }

}
