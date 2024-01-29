package app.system.employee.api;

import app.system.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeApiController {

    private final EmployeeService employeeService;

    @DeleteMapping("/{idEmployee}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long idEmployee){
        employeeService.deleteEmployee(idEmployee);
        return ResponseEntity.ok().build();
    }

}
