package app.system.employee.service;

import app.system.employee.dto.PagedData;
import app.system.employee.dto.request.GetEmployeesDTO;
import app.system.employee.dto.request.NewEmployeeDTO;
import app.system.employee.dto.response.EmployeeDTO;

import java.util.Optional;

public interface EmployeeService {

    void createEmployee(NewEmployeeDTO newEmployee);

    PagedData<EmployeeDTO> getEmployees(GetEmployeesDTO request);

    Optional<EmployeeDTO> getEmployee(Long idEmployee);

    void deleteEmployee(Long idEmployee);
}
