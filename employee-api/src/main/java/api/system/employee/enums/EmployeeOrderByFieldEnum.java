package api.system.employee.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum EmployeeOrderByFieldEnum {

    NAME("name", "Nombre"),
    LASTNAME("lastname", "Apellido"),
    BIRTHDATE("birthdate", "Fecha Nacimiento"),
    REGISTRATION_DATE("registrationDate", "Fecha Registro");

    private final String field;
    private final String fieldName;

    public static EmployeeOrderByFieldEnum findByName(String name) {
        if (Objects.isNull(name)) {
            return REGISTRATION_DATE;
        }
        return Arrays.stream(EmployeeOrderByFieldEnum.values())
                     .filter(v -> v.name().equals(name))
                     .findAny()
                     .orElse(REGISTRATION_DATE);
    }

}
