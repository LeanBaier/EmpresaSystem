package api.system.empresa.repository;

import api.system.empresa.dto.PagedData;
import api.system.empresa.model.EmployeeModel;

import java.util.List;

public interface EmployeeRepository {

    EmployeeModel save(EmployeeModel employeeModel);

    PagedData<EmployeeModel> getEmployeeModels(Integer page, Integer size);

}
