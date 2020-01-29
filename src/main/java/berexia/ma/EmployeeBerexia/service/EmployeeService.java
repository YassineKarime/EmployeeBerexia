package berexia.ma.EmployeeBerexia.service;

import berexia.ma.EmployeeBerexia.Exception.ResourceNotFoundException;
import berexia.ma.EmployeeBerexia.dao.EmployeeRepository;
import berexia.ma.EmployeeBerexia.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class EmployeeService {
    public static  final Logger LOG= LogManager.getLogger(EmployeeService.class);

    @Autowired
     EmployeeRepository employeeRepository;
    public List<Employee> searchByName(String name) {
        return  employeeRepository.findByLastNameContaining(name);
    }
    public List<Employee> getAllEmployees() {
        return  employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }


    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee emplyeeToUpdate) {
        Optional<Employee> emp = getEmployeeById(emplyeeToUpdate.getId());
        Employee employe = null;
        LOG.info(emplyeeToUpdate);
        if(emp.isPresent()){
            employe = emp.get();
            employe.setFirstName(emplyeeToUpdate.getFirstName());
            employe.setLastName(emplyeeToUpdate.getLastName());
            employe.setEmailId(emplyeeToUpdate.getEmailId());
            LOG.info("EMPLOYEE IS PRESENT .................");
            employe = employeeRepository.save(employe);
        }else{
            try {
                throw new ResourceNotFoundException("EMPLOYEE NOT FOUND !!!!!!!!!!");
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        LOG.info(employe);
        return employe;
    }

    public boolean deleteEmployee(Long employeeId)
            throws ResourceNotFoundException {
        AtomicBoolean result = new AtomicBoolean(false);
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        employee.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        employee.ifPresent(s-> {
            employeeRepository.delete(s);
            result.set(true);
        });
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//        employeeRepository.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
        return result.get();
    }
}
