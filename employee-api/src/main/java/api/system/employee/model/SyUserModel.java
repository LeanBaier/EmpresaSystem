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
@Table(name = "SY_USER")
public class SyUserModel implements Serializable {

    @Id
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASS")
    private String password;
    @Column(name = "EMAIL")
    private String email;

    @ManyToMany
    @JoinTable(name = "SY_USER_ROLE",
               joinColumns = @JoinColumn(name = "USERNAME"),
               inverseJoinColumns = @JoinColumn(name = "ID_ROLE")
    )
    private List<SyRoleModel> roles;

}
