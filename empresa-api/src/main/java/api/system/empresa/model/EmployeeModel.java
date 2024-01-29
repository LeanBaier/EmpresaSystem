package api.system.empresa.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class EmployeeModel implements Serializable {

    private Long idEmployee;
    private String name;
    private String lastname;
    private Date birthdate;
    private Date registrationDate;

}
