package com.miniproj.management.domain.employee;

import com.miniproj.management.domain.team.Team;
import com.miniproj.management.dto.employee.request.EmployeeSaveRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;

    private String name;

    private boolean isManager;

    private LocalDate birthday;

    private LocalDate workStartDate;

    public boolean isManager() {
        return isManager;
    }

    public Employee(Team team, String name, boolean isManager, LocalDate birthday, LocalDate workStartDate) {
        this.team = team;
        this.name = name;
        this.isManager = isManager;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    public Employee(Team team, EmployeeSaveRequest request) {
        this.team = team;
        this.name = request.getName();
        this.isManager = request.getIsManager();
        this.birthday = request.getBirthday();
        this.workStartDate = request.getWorkStartDate();
    }

}
