package com.badinho.ssstarter.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class User {
    private final Integer userId;
    private final String username;
}
