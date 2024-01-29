package app.system.employee.service;

import app.system.employee.dto.GetEmployeesRequest;
import app.system.employee.dto.NewEmployeeDTO;
import app.system.employee.dto.PagedData;
import app.system.employee.model.EmployeeModel;

import java.util.Optional;

public interface EmployeeService {

    void createEmployee(NewEmployeeDTO newEmployee);
    PagedData<EmployeeModel> getEmployees(GetEmployeesRequest request);
    Optional<EmployeeModel> getEmployee(Long idEmployee);

    void deleteEmployee(Long idEmployee);
}
