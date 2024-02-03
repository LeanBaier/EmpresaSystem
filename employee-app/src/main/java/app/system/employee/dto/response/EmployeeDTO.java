package app.system.employee.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDTO implements Serializable {

    private Long idEmployee;
    private String name;
    private String lastname;
    private Date birthdate;
    private Date registrationDate;

}
