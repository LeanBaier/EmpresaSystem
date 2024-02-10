package api.system.employee.mapper;

import api.system.employee.dto.request.NewEmployeeDTO;
import api.system.employee.dto.response.EmployeeDTO;
import api.system.employee.model.EmployeeModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static EmployeeModel toModel(NewEmployeeDTO dto) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return EmployeeModel.builder()
                .registrationDate(new Date())
                .name(dto.getName())
                .lastname(dto.getLastname())
                .birthdate(formatter.parse(dto.getBirthdate()))
                .build();
    }

}
