package com.miniproj.management.domain.team;

import com.miniproj.management.domain.employee.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Employee> employee;

    public Team(String name) {
        this.name = name;
    }

    public String getManager() {
        Employee manager = employee.stream()
                .filter(emp -> emp.isManager()).findFirst().orElse(null);
        return manager == null ? null : manager.getName();
    }

    public int getNumberOfEmp() {
        return employee.size();
    }
}
