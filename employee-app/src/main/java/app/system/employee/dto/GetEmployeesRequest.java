package app.system.employee.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;

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
    private String order;

    public static GetEmployeesRequest buildDefault() {
        return GetEmployeesRequest.builder()
                .page(1)
                .size(20)
                .order("ASC")
                .build();
    }
}
