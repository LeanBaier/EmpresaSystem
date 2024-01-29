package api.system.empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PagedData<DATA> implements Serializable {

    private Integer page;
    private Integer size;
    private Integer totalPages;
    private Integer totalRecords;
    private List<DATA> data;

}
