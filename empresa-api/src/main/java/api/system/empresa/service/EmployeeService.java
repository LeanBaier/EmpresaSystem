package api.system.empresa.service;

import api.system.empresa.dto.GetEmployeesRequest;
import api.system.empresa.dto.NewEmployeeDTO;
import api.system.empresa.dto.PagedData;
import api.system.empresa.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    void createEmployee(NewEmployeeDTO newEmployee);
    PagedData<EmployeeModel> getEmployees(GetEmployeesRequest request);
    Optional<EmployeeModel> getEmployee(Long idEmployee);

}
