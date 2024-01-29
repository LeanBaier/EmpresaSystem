package app.system.employee.service.impl;

import app.system.employee.dto.GetEmployeesRequest;
import app.system.employee.dto.NewEmployeeDTO;
import app.system.employee.dto.PagedData;
import app.system.employee.model.EmployeeModel;
import app.system.employee.repository.EmployeeRepository;
import app.system.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(NewEmployeeDTO newEmployee) {

    }

    @Override
    public PagedData<EmployeeModel> getEmployees(GetEmployeesRequest request) {
        return employeeRepository.getEmployeeModels(request.getPage(), request.getSize());
    }

    @Override
    public Optional<EmployeeModel> getEmployee(Long idEmployee) {
        return Optional.empty();
    }

    @Override
    public void deleteEmployee(Long idEmployee) {
        employeeRepository.deleteById(idEmployee);
    }
}
