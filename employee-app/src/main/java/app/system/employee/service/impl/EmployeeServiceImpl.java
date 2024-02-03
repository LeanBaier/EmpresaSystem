package app.system.employee.service.impl;

import app.system.employee.dto.PagedData;
import app.system.employee.dto.request.GetEmployeesRequest;
import app.system.employee.dto.request.NewEmployeeRequest;
import app.system.employee.dto.response.EmployeeDTO;
import app.system.employee.enums.EmployeeOrderByFieldEnum;
import app.system.employee.mapper.EmployeeMapper;
import app.system.employee.repository.EmployeeRepository;
import app.system.employee.repository.spec.EmployeeSpecifications;
import app.system.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(NewEmployeeRequest newEmployee) {

    }

    @Override
    public PagedData<EmployeeDTO> getEmployees(GetEmployeesRequest request) {
        Sort sort = Sort.by(EmployeeOrderByFieldEnum.findByName(request.getOrderBy())
                                                    .getField());
        sort = (Objects.nonNull(request.getOrder()) && request.getOrder()
                                                              .equals("ASC")) ?
               sort.ascending() :
               sort.descending();
        Pageable pageable = PageRequest.of(request.getPage() - 1, request.getSize(), sort);

        var spec = EmployeeSpecifications.findByLastname(request.getLastname())
                                         .and(EmployeeSpecifications.findByName(request.getName()));
        var data = employeeRepository.findAll(spec, pageable);

        return PagedData.<EmployeeDTO>builder()
                        .page(request.getPage())
                        .size(request.getSize())
                        .totalPages(data.getTotalPages())
                        .totalRecords(data.getTotalElements())
                        .data(data.get().map(EmployeeMapper::toDTO).toList())
                        .build();
    }

    @Override
    public Optional<EmployeeDTO> getEmployee(Long idEmployee) {
        return Optional.empty();
    }

    @Override
    public void deleteEmployee(Long idEmployee) {
        employeeRepository.deleteById(idEmployee);
    }
}
