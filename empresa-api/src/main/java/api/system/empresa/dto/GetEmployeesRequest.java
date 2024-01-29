package api.system.empresa.dto;

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
public class GetEmployeesRequest implements Serializable {

    @NotNull
    @Positive
    private Integer page;
    @NotNull
    @Positive
    private Integer size;
    private String order;

}
