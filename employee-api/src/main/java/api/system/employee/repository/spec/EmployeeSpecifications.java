package api.system.employee.repository.spec;

import api.system.employee.model.EmployeeModel;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class EmployeeSpecifications {

    public static Specification<EmployeeModel> findByName(String name) {
        return (root, query, cb) -> {
            if (Objects.isNull(name)) {
                return null;
            }

            return cb.like(root.get("name"), "%" + name.trim() + "%");
        };
    }

    public static Specification<EmployeeModel> findByLastname(String lastname) {
        return (root, query, cb) -> {
            if (Objects.isNull(lastname)) {
                return null;
            }

            return cb.like(root.get("lastname"), "%" + lastname.trim() + "%");
        };
    }

}
