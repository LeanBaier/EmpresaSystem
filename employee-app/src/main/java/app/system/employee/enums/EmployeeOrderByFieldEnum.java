package app.system.employee.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmployeeOrderByFieldEnum {

    NAME("name"),
    LASTNAME("lastname"),
    BIRTHDATE("birthdate"),
    REGISTRATION_DATE("registrationDate");

    private final String field;



}
