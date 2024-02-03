package app.system.employee.repository;

import app.system.employee.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>, JpaSpecificationExecutor<EmployeeModel> {
}
