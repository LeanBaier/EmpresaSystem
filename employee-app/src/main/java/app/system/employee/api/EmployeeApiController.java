package app.system.employee.api;

import app.system.employee.dto.GetEmployeesRequest;
import app.system.employee.dto.PagedData;
import app.system.employee.model.EmployeeModel;
import app.system.employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeApiController {

    private final EmployeeService employeeService;

    @DeleteMapping("/{idEmployee}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long idEmployee) {
        employeeService.deleteEmployee(idEmployee);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<PagedData<EmployeeModel>> searchEmployees(@Valid GetEmployeesRequest filters) {
        var result = employeeService.getEmployees(filters);
        return ResponseEntity.ok(result);
    }


}
