package com.badinho.ssstarter.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private static final List<User> USERS = Arrays.asList(
            User.builder()
                    .userId(1)
                    .username("badinho")
                    .build(),
            User.builder()
                    .userId(2)
                    .username("peralitos")
                    .build(),
            User.builder()
                    .userId(3)
                    .username("wawito")
                    .build()
    );

    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable("userId") Integer userId) {
        return USERS.stream()
                .filter(user -> userId.equals(user.getUserId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "User " + userId + " does not exists"
                ));
    }
}
