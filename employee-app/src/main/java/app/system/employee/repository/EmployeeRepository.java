package app.system.employee.repository;

import app.system.employee.dto.PagedData;
import app.system.employee.model.EmployeeModel;

public interface EmployeeRepository {

    EmployeeModel save(EmployeeModel employeeModel);

    PagedData<EmployeeModel> getEmployeeModels(Integer page, Integer size);

    void deleteById(Long idEmployee);
}
