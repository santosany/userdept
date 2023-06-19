package test;

import com.anystudent.userdept.UserdeptApplication;
import com.anystudent.userdept.dto.DepartmentDTO;
import com.anystudent.userdept.dto.UserDTO;
import com.anystudent.userdept.entities.Department;
import com.anystudent.userdept.entities.User;
import com.anystudent.userdept.repositories.DepartmentRepository;
import com.anystudent.userdept.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = UserdeptApplication.class)
public class DepartmentServiceTest {
    private static final Long ID=1L;
    private static final String NAME = "People";

    Department department = new Department(ID,NAME);

    @Autowired
    DepartmentService departmentService;

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    public void findAll(){
        assertTrue(departmentRepository.findAll().size() > 0);
    }

    @Test
    public void departmentFindById(){
        department.setId(1L);
        assertEquals(ID,department.getId());
    }

    @Test
    public void saveDepartment(){
        DepartmentDTO departmentDTO = new DepartmentDTO(ID,NAME);
        int tamanho_antes = departmentRepository.findAll().size();
        departmentService.saveDepartment(departmentDTO);
        int tamanho_depois = departmentRepository.findAll().size();
        assertNotEquals(tamanho_antes,tamanho_depois);

    }

    @Test
    public void updateDepartment(){
        Optional<Department> userToUpdate = departmentRepository.findById(2L);

        String dptNameAntes = userToUpdate.get().getName();

        DepartmentDTO updatedDptDto = new DepartmentDTO();
        updatedDptDto.setName("Comercial");

        departmentService.updateDepartment(2L, updatedDptDto);

        Department departmentAtualizado = departmentRepository.findById(2L).orElse(null);

        assertNotNull(departmentAtualizado);

        assertEquals("Comercial", departmentAtualizado.getName());

        assertNotEquals(dptNameAntes, departmentAtualizado.getName());

    }

    @Test
    public void deleteUserById(){
        Department department = new Department(4L,"Manager");
        int tamanho_antes = departmentRepository.findAll().size();
        departmentService.deleteDepartmentById(department.getId());
        int tamanho_depois = departmentRepository.findAll().size();
        assertNotEquals(tamanho_antes,tamanho_depois);
    }
}
