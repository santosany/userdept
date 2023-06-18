package test;

import com.anystudent.userdept.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserControllerTest {
    UserService userService = new UserService();

    @Test
    public void getFindById(){
        userService.findAll();
        assertEquals(1L, userService.findAll());
    }
}
