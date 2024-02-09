package api.system.employee.dto.request;

import api.system.employee.validators.AscDesc;
import api.system.employee.validators.DateFormat;
import api.system.employee.validators.OrderByFieldEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetEmployeesDTO implements Serializable {

    @NotNull
    @Positive
    private Integer page;
    @NotNull
    @Positive
    private Integer size;
    @AscDesc
    private String order;
    private String name;
    private String lastname;
    @OrderByFieldEnum
    private String orderBy;
    @DateFormat(pattern = "yyyy-MM-dd")
    private String birthdateSince;
    @DateFormat(pattern = "yyyy-MM-dd")
    private String birthdateUntil;
    @DateFormat(pattern = "yyyy-MM-dd")
    private String registrationDateSince;
    @DateFormat(pattern = "yyyy-MM-dd")
    private String registrationDateUntil;
}

