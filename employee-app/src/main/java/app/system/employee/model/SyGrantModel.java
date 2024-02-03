package app.system.employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "SY_GRANT")
public class SyGrantModel implements Serializable {

    @Id
    @Column(name = "ID_GRANT")
    private Integer idGrant;
    @Column(name = "name")
    private String name;

}
