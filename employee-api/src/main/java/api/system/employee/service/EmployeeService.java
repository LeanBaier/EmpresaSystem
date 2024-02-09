package api.system.employee.service;

import api.system.employee.dto.PagedData;
import api.system.employee.dto.request.GetEmployeesDTO;
import api.system.employee.dto.request.NewEmployeeDTO;
import api.system.employee.dto.response.EmployeeDTO;

import java.util.Optional;

public interface EmployeeService {

    void createEmployee(NewEmployeeDTO newEmployee);

    PagedData<EmployeeDTO> getEmployees(GetEmployeesDTO request);

    Optional<EmployeeDTO> getEmployee(Long idEmployee);

    void deleteEmployee(Long idEmployee);
}
