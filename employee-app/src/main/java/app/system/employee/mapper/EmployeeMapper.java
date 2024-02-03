package app.system.employee.mapper;

import app.system.employee.dto.response.EmployeeDTO;
import app.system.employee.model.EmployeeModel;

public class EmployeeMapper {

    private EmployeeMapper() {

    }

    public static EmployeeDTO toDTO(EmployeeModel model) {
        return EmployeeDTO.builder()
                          .idEmployee(model.getIdEmployee())
                          .name(model.getName())
                          .lastname(model.getLastname())
                          .birthdate(model.getBirthdate())
                          .registrationDate(model.getRegistrationDate())
                          .build();
    }

}
