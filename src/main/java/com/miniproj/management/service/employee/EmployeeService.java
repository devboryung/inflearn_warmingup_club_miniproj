package com.miniproj.management.service.employee;

import com.miniproj.management.domain.employee.Employee;
import com.miniproj.management.domain.employee.EmployeeRepository;
import com.miniproj.management.domain.team.Team;
import com.miniproj.management.domain.team.TeamRepository;
import com.miniproj.management.dto.employee.request.EmployeeSaveRequest;
import com.miniproj.management.dto.employee.response.EmployeeResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    public EmployeeService(EmployeeRepository employeeRepository, TeamRepository teamRepository) {
        this.employeeRepository = employeeRepository;
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveEmployee(EmployeeSaveRequest request) {
        //1.팀이름으로 팀id를 찾는다.
        Team team = teamRepository.findByName(request.getTeamName()).orElseThrow(IllegalArgumentException::new);
        //2.직원을 저장한다.
        //employeeRepository.save(new Employee(team, request.getName(), request.isManager(), request.getWorkStartDate(), request.getBirthday()));
        employeeRepository.save(new Employee(team, request));
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponse> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> empList = employees.stream().map(emp -> new EmployeeResponse(emp)).collect(Collectors.toList());
        return empList;
    }
}
