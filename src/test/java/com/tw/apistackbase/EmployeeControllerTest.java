package com.tw.apistackbase;
import com.tw.apistackbase.controller.EmployeeController;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void should_return_employee_when_given_employeeId() throws Exception {
        Employee employee = new Employee("1111", "test", "Male", 24);

        when(employeeService.getById(anyString())).thenReturn(employee);

        ResultActions result = mvc.perform(get("/employees/{id}", employee.getId()));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is("1111")))
                .andExpect(jsonPath("$.name", is("test")))
                .andExpect(jsonPath("$.gender", is("Male")))
                .andExpect(jsonPath("$.age", is(24)));
    }
}
