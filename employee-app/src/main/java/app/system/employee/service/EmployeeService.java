package app.system.employee.service;

import app.system.employee.dto.PagedData;
import app.system.employee.dto.request.GetEmployeesRequest;
import app.system.employee.dto.request.NewEmployeeRequest;
import app.system.employee.dto.response.EmployeeDTO;

import java.util.Optional;

public interface EmployeeService {

    void createEmployee(NewEmployeeRequest newEmployee);

    PagedData<EmployeeDTO> getEmployees(GetEmployeesRequest request);

    Optional<EmployeeDTO> getEmployee(Long idEmployee);

    void deleteEmployee(Long idEmployee);
}
