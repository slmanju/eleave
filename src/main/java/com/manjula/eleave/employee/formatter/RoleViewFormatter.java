package com.manjula.eleave.employee.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.manjula.myleave.rbac.view.RoleView;

public class RoleViewFormatter implements Formatter<RoleView> {

    @Override
    public String print(RoleView view, Locale locale) {
        System.out.println("[PRINT:" + view + "] [" + view.getId() + "]");
        return view.getId();
    }

    @Override
    public RoleView parse(String text, Locale locale) throws ParseException {
        System.out.println("[PARSE:" + text + "]");
        if (text == null || text.isEmpty()) {
            throw new ParseException("Invalid format", -1);
        }
        RoleView view = new RoleView();
        view.setId(text);
        return view;
    }

}
