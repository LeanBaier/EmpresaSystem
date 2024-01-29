package api.system.empresa.service.impl;

import api.system.empresa.dto.GetEmployeesRequest;
import api.system.empresa.dto.NewEmployeeDTO;
import api.system.empresa.dto.PagedData;
import api.system.empresa.model.EmployeeModel;
import api.system.empresa.repository.EmployeeRepository;
import api.system.empresa.service.EmployeeService;
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
}
