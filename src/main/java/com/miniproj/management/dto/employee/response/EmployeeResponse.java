package com.miniproj.management.dto.employee.response;

import com.miniproj.management.domain.employee.Employee;
import com.miniproj.management.domain.employee.EmployeeRole;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class EmployeeResponse {

    private String name;
    private String teamName;
    private EmployeeRole role;
    private LocalDate birthday;
    private LocalDate workStartDate;

    public EmployeeResponse(Employee employee) {
        this.name = employee.getName();
        this.teamName = employee.getTeam().getName();
        this.role = employee.isManager() ? EmployeeRole.MANAGER : EmployeeRole.MEMBER;
        this.birthday = employee.getBirthday();
        this.workStartDate = employee.getWorkStartDate();
    }
}
