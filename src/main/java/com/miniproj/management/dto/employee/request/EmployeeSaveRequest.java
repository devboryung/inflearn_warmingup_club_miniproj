package com.miniproj.management.dto.employee.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeSaveRequest {

    private String name;
    private String teamName;
    private boolean isManager;
    private LocalDate workStartDate;
    private LocalDate birthday;

    public boolean getIsManager() {
        return isManager;
    }
}
