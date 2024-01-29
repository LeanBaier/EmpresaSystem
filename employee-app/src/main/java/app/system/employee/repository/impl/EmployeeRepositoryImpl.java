package app.system.employee.repository.impl;

import app.system.employee.dto.PagedData;
import app.system.employee.model.EmployeeModel;
import app.system.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static Long id = 0L;
    private final List<EmployeeModel> models;

    public EmployeeRepositoryImpl() {
        this.models = new ArrayList<>();

        for (int i = 1; i <= 200; i++) {
            models.add(EmployeeModel.builder()
                                    .birthdate(new Date())
                                    .name("name " + i)
                                    .lastname("lastname " + i)
                                    .idEmployee(++id)
                                    .registrationDate(new Date())
                                    .build()
            );
        }
    }


    @Override
    public EmployeeModel save(EmployeeModel employeeModel) {
        employeeModel.setIdEmployee(++id);
        this.models.add(employeeModel);
        return employeeModel;
    }

    @Override
    public PagedData<EmployeeModel> getEmployeeModels(Integer page, Integer size) {
        int indexEnd = page > 1 ?
                       (page) * size :
                       size;
        int indexStart = indexEnd - size;
        if (models.size() > indexStart) {
            var result = models.subList(indexStart, Math.min(models.size() - 1, indexEnd));
            return PagedData.<EmployeeModel>builder()
                            .page(page)
                            .size(result.size())
                            .totalPages(BigDecimal.valueOf(models.size() / size)
                                                  .setScale(1, RoundingMode.UP)
                                                  .intValue())
                            .totalRecords(models.size())
                            .data(result)
                            .build();
        }
        return PagedData.<EmployeeModel>builder()
                        .totalPages(0)
                        .size(0)
                        .page(page)
                        .totalRecords(0)
                        .data(new ArrayList<>())
                        .build();
    }

    @Override
    public void deleteById(Long idEmployee) {
        this.models.removeIf(e -> e.getIdEmployee().equals(idEmployee));
    }
}
