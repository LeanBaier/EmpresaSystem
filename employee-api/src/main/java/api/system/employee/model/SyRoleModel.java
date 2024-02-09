package api.system.employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "SY_ROLE")
public class SyRoleModel implements Serializable {

    @Id
    @Column(name = "ID_ROLE")
    private Integer idRole;
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany
    @JoinTable(name = "SY_ROLE_GRANT",
               joinColumns = @JoinColumn(name = "ID_ROLE"),
               inverseJoinColumns = @JoinColumn(name = "ID_GRANT")
    )
    private List<SyGrantModel> grants;
}
