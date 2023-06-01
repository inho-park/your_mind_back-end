package com.daelim.yourmind.common.domain;

import com.daelim.yourmind.user.domain.Role;
import com.daelim.yourmind.user.domain.User;
import com.daelim.yourmind.user.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository repository;

    @Test
    public void 멤버_생성() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            User user = User.builder()
                    .name("name"+i)
                    .username("username"+i)
                    .message("message"+i)
                    .password("password"+i)
                    .age(i)
                    .isCounselor(i % 2 == 1)
                    .build();

            repository.save(user);
        });
    }


}
