package app.system.employee.repository;

import app.system.employee.model.SyUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SyUserRepository extends JpaRepository<SyUserModel, String> {
}
