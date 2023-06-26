package com.badinho.ssstarter.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;

import java.util.Set;

import static com.badinho.ssstarter.security.ApplicationUserPermission.*;

@AllArgsConstructor
public enum ApplicationUserRole {
    USER(Sets.newHashSet(
            USER_READ
    )),
    ADMIN(Sets.newHashSet(
            USER_READ,
            USER_WRITE
    ));

    private final Set<ApplicationUserPermission> permissions;
}
