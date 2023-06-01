package com.daelim.yourmind.common.service;

import com.daelim.yourmind.user.domain.Role;
import com.daelim.yourmind.user.domain.User;
import com.daelim.yourmind.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.stream.IntStream;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void 유저_추가() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            if (i%2==0) userService.saveUser(new User(null, "name" + i, "username" + i, "password" + i, "message" + i, i, true, new ArrayList<>()));
            else userService.saveUser(new User(null, "name" + i, "username" + i, "password" + i, "message" + i, i, false, new ArrayList<>()));
        });
    }

    @Test
    public void 롤_추가() {
        userService.saveRole(new Role(null, "ROLE_USER"));
        userService.saveRole(new Role(null, "ROLE_COUNSELOR"));
    }

    @Test
    public void 유저_롤_추가() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            User user = userService.getUser("username" + i);
            if (user.isCounselor()) userService.addRoleToUser("username" + i,"ROLE_COUNSELOR");
            userService.addRoleToUser("username" + i,"ROLE_USER");
        });
    }
}
