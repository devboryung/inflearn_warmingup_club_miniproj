package com.miniproj.management.controller.employee;

import com.miniproj.management.dto.employee.request.EmployeeSaveRequest;
import com.miniproj.management.dto.employee.response.EmployeeResponse;
import com.miniproj.management.service.employee.EmployeeService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/emp/save")
    public void saveEmployee(@RequestBody EmployeeSaveRequest request) {
        employeeService.saveEmployee(request);
    }

    @GetMapping("/emp")
    public List<EmployeeResponse> getEmployees() {
        return employeeService.getEmployees();
    }
}
