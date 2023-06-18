package com.anystudent.userdept.dto;

import com.anystudent.userdept.dto.UserDTO;
import com.anystudent.userdept.entities.User;

public class UserMapperDTO {
    public static User userDtoToUser(UserDTO newUser) {

        User user = new User();
        user.setUserEmail(newUser.getEmail());
        user.setUserName(newUser.getName());
        user.setUserDepartment(Long.valueOf(newUser.getDepartment()));

        return user;

    }
}
