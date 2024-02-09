package api.system.employee.mapper;

import api.system.employee.model.EmployeeModel;
import api.system.employee.dto.response.EmployeeDTO;

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
