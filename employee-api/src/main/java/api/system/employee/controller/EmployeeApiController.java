package api.system.employee.controller;

import api.system.employee.dto.PagedData;
import api.system.employee.dto.request.GetEmployeesDTO;
import api.system.employee.dto.request.NewEmployeeDTO;
import api.system.employee.dto.response.EmployeeDTO;
import api.system.employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
@Validated
public class EmployeeApiController {

    private final EmployeeService employeeService;

    @DeleteMapping("/{idEmployee}")
    public void deleteEmployee(@PathVariable Long idEmployee) {
        employeeService.deleteEmployee(idEmployee);
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('EMPLOYEES')")
    public PagedData<EmployeeDTO> searchEmployees(@Valid GetEmployeesDTO filters) {
        return employeeService.getEmployees(filters);
    }

    @PostMapping
    @PreAuthorize("hasRole('EMPLOYEES')")
    public EmployeeDTO createEmployee(@RequestBody @Valid NewEmployeeDTO request) {
        return employeeService.createEmployee(request);
    }

}
