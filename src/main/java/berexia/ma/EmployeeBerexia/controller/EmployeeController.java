package berexia.ma.EmployeeBerexia.controller;

import berexia.ma.EmployeeBerexia.Exception.ResourceNotFoundException;
import berexia.ma.EmployeeBerexia.model.Employee;
import berexia.ma.EmployeeBerexia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public ResponseEntity<?> getEmployees() {
        try {
            return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("Failed to retrieve the list of employees (caused By :)", HttpStatus.OK);
        }
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/employees/search/{name}")
    public ResponseEntity<Object> SearchByName(@PathVariable String name) {
        return new ResponseEntity<>(employeeService.searchByName(name), HttpStatus.OK);
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {

        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) throws ResourceNotFoundException {
        boolean result = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
