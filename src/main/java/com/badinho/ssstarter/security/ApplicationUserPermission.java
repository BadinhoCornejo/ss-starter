package com.badinho.ssstarter.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;
}
