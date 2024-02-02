package app.system.employee.dto;

import app.system.employee.validators.AscDescValidator;
import app.system.employee.validators.OrderByFieldEnumValidator;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class GetEmployeesRequest implements Serializable {

    @NotNull
    @Positive
    private Integer page;
    @NotNull
    @Positive
    private Integer size;
    @AscDescValidator
    private String order;
    private String name;
    private String lastname;
    @OrderByFieldEnumValidator
    private String orderBy;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthdate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date registrationDate;
}

