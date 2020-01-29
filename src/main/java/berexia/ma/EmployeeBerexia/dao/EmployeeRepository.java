package berexia.ma.EmployeeBerexia.dao;

import berexia.ma.EmployeeBerexia.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByLastNameContaining(String lastName);
}
