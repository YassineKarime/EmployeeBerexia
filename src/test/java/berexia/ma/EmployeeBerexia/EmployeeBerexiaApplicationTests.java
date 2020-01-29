package berexia.ma.EmployeeBerexia;

import berexia.ma.EmployeeBerexia.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeBerexiaApplicationTests {
	@Autowired
	private MockMvc mvc ;
	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void createTest() throws Exception {
		Employee dep = new Employee();
		dep.setFirstName("departement pmopmlmp");
		dep.setLastName("gfhgfh");
		dep.setEmailId("hffghft");
		ResultActions rs = mvc.perform( post("/emp/create")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(dep)))
				.andExpect(status().isCreated());
		rs.andDo(print());
	}
}
