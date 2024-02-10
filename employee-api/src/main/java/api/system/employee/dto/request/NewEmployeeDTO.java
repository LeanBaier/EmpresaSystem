package api.system.employee.dto.request;

import api.system.employee.validators.DateFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewEmployeeDTO implements Serializable {

    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @DateFormat(pattern = "dd-MM-yyyy")
    private String birthdate;

}
