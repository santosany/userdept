package test;

import com.anystudent.userdept.entities.Department;
import com.anystudent.userdept.entities.User;
import com.anystudent.userdept.repositories.UserRepository;
import com.anystudent.userdept.service.UserService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;


import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {
    private static final Long ID=1L;
    private static final String NAME = "Carla";
    private static final String EMAIL = "carla@gmail.com";
    //private static final Department DEPARTMENT = (1L, "IT");

    @InjectMocks
    private UserService service;
    @Mock
    private UserRepository repository;

    @Mock
    private User user;
    @Mock
    private Optional<User> optionalUser;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
    }

    @Test
    void userFindById() {
    }

    @Test
    void mergeUser() {
    }

    @Test
    void deleteUserById() {
    }

//    private void startUser(){
//        user = new User(ID,NAME,EMAIL,DEPARTMENT);
//        optionalUser= new Optional.of(new User(ID,NAME,EMAIL,DEPARTMENT));
//    }
}
