package api.system.empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewEmployeeDTO implements Serializable {

    private String name;
    private String lastname;
    private Date birthDate;

}
