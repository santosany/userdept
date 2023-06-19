package test;

import com.anystudent.userdept.UserdeptApplication;
import com.anystudent.userdept.dto.UserDTO;
import com.anystudent.userdept.dto.UserMapperDTO;
import com.anystudent.userdept.entities.Department;
import com.anystudent.userdept.entities.User;
import com.anystudent.userdept.repositories.UserRepository;
import com.anystudent.userdept.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = UserdeptApplication.class)
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

        assertTrue(userRepository.findAll().size() > 0);
    }

    @Test
    public void userFindById() {
        user.setUserId(1L);
        assertEquals(ID,user.getUserId());
    }

    @Test
    public void saveUser() {
        UserDTO userDTO = new UserDTO(NAME,EMAIL,"1");
        int tamanho_antes = userRepository.findAll().size();
        userService.saveUser(userDTO);
        int tamanho_depois = userRepository.findAll().size();
        assertNotEquals(tamanho_antes,tamanho_depois);
    }

    @Test
    public void updateUser() {

        Optional<User> userToUpdate = userRepository.findById(2L);

        String userNameAntes = userToUpdate.get().getUserName();

        UserDTO updatedUserDto = new UserDTO();
        updatedUserDto.setName("Vinicius");
        updatedUserDto.setEmail("maria@gmail.com");
        updatedUserDto.setDepartment("2");

        userService.updateUser(2L, updatedUserDto);

        User userAtualizado = userRepository.findById(2L).orElse(null);

        assertNotNull(userAtualizado);

        assertEquals("Vinicius", userAtualizado.getUserName());

        assertNotEquals(userNameAntes, userAtualizado.getUserName());
    }

    @Test
    void deleteUserById() {
        User user = new User(10L,"Maria","maria@gmail.com",1L);
        int tamanho_antes = userRepository.findAll().size();
        userService.deleteUserById(user.getUserId());
        int tamanho_depois = userRepository.findAll().size();
        assertNotEquals(tamanho_antes,tamanho_depois);
    }
}
