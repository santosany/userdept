package test;

import com.anystudent.userdept.entities.Department;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentTest {

    Department department = new Department(1L,"IT");

    @Test
    public void getDepartmentId(){
        assertEquals(1, department.getId());
    }

    @Test
    public void getDepartmentName(){
        assertEquals("IT", department.getName());
    }
}
