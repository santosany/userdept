package test;

import static org.junit.jupiter.api.Assertions.*;
import com.anystudent.userdept.entities.Department;
import com.anystudent.userdept.entities.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class UserTest {

    Department department = new Department(1L,"IT");

    User user =  new User(1L,"Maria","maria@gmail.com",1L);

    @Test
    public void getUserId(){
        assertEquals(1, user.getUserId());
    }

    @Test
    public void getUserName(){
            assertEquals("Maria", user.getUserName());
    }

    @Test
    public void getUserEmail(){
        assertEquals("maria@gmail.com", user.getUserEmail());
    }

//    @Test
//    public void getUserDepartmentNome(){
//        assertEquals(1L,user.getUserDepartment());
//    }
}
