package api.system.employee.repository;

import api.system.employee.model.SyUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SyUserRepository extends JpaRepository<SyUserModel, String> {
}
