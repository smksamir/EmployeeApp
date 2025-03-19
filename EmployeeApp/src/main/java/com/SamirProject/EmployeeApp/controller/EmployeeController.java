package com.SamirProject.EmployeeApp.controller;

import com.SamirProject.EmployeeApp.model.Employee;
import com.SamirProject.EmployeeApp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/getDepartment")
    public String getDepartment(@RequestParam("employeeId") String employeeId,
                                @RequestParam("name") String name,
                                Model model) {
        Employee employee = employeeService.getEmployeeByIdAndName(employeeId, name);
        if (employee != null) {
            model.addAttribute("department", employee.getDepartment());
        } else {
            model.addAttribute("error", "Employee Not Found or Name does not match.");
        }
        return "index";
    }
}
