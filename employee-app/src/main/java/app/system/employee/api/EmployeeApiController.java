package app.system.employee.api;

import app.system.employee.dto.FieldOrderDTO;
import app.system.employee.dto.GetEmployeesRequest;
import app.system.employee.dto.PagedData;
import app.system.employee.enums.EmployeeOrderByFieldEnum;
import app.system.employee.model.EmployeeModel;
import app.system.employee.service.EmployeeService;
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
    @PreAuthorize("hasRole('USER')")
    public PagedData<EmployeeModel> searchEmployees(@Valid GetEmployeesRequest filters) {
        return employeeService.getEmployees(filters);
    }

    @GetMapping("/search/order-by-fields")
    public List<FieldOrderDTO> orderByFields() {
        return Arrays.stream(EmployeeOrderByFieldEnum.values())
                     .map(f -> FieldOrderDTO.builder()
                                            .orderByFieldName(f.name())
                                            .employeeModelField(f.getField())
                                            .build())
                     .toList();
    }

}
