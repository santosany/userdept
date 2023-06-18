package test;

import com.anystudent.userdept.entities.User;
import com.anystudent.userdept.repositories.UserRepository;
import com.anystudent.userdept.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {
    private static final Long ID=1L;
    private static final String NAME = "Carla";
    private static final String EMAIL = "carla@gmail.com";
    private static final Long DEPARTMENT = 1L;

    User user =  new User(ID,NAME,EMAIL,DEPARTMENT);
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Test
    public void findAll() {
        assertEquals(user, userRepository.findAll());

    }

    @Test
    public void userFindById() {
        user.setUserId(1L);
        assertEquals(ID,userService.userFindById(user.getUserId()));
    }

    @Test
    public void saveUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    void deleteUserById() {
    }
}
