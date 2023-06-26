package com.badinho.ssstarter.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationUserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;
}
