package api.system.employee.controller;

import api.system.employee.dto.PagedData;
import api.system.employee.enums.EmployeeOrderByFieldEnum;
import api.system.employee.service.EmployeeService;
import api.system.employee.dto.response.EmployeeDTO;
import api.system.employee.dto.response.FieldOrderDTO;
import api.system.employee.dto.request.GetEmployeesDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
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

    @GetMapping("/search/order-by-fields")
    public List<FieldOrderDTO> orderByFields() {
        return Arrays.stream(EmployeeOrderByFieldEnum.values())
                     .map(f -> FieldOrderDTO.builder()
                                            .orderByFieldName(f.name())
                                            .fieldName(f.getFieldName())
                                            .build())
                     .toList();
    }

}
