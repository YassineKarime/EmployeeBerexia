package berexia.ma.EmployeeBerexia;

import berexia.ma.EmployeeBerexia.dao.EmployeeRepository;
import berexia.ma.EmployeeBerexia.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeBerexiaApplication {
//	@Autowired
//EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeBerexiaApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		employeeRepository.save(new Employee("Yassine","karim","yassine.karim@ber.com"));
//		employeeRepository.save(new Employee("ahmed","malki","malki.ahmed@ber.com"));
//		employeeRepository.save(new Employee("anas","janah","janah.janah@ber.com"));
//		employeeRepository.save(new Employee("aymen","aytabdallah","aytabdallah.aymen@ber.com"));
//		employeeRepository.save(new Employee("said","mohssine","mohssine.said@ber.com"));
//		employeeRepository.save(new Employee("chafik","fanidi","fanidi.chafik@ber.com"));
//
//
//
//
//
//		employeeRepository.findAll().forEach(e->{
//			System.out.println(e.getLastName());
//		});
//	}
}
