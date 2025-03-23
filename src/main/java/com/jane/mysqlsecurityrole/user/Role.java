package com.jane.mysqlsecurityrole.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.List;

import static com.jane.mysqlsecurityrole.user.Permission.*;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    ADMIN_UPDATE,
                    ADMIN_READ,
                    MANAGER_CREATE,
                    MANAGER_DELETE,
                    MANAGER_UPDATE,
                    MANAGER_READ
            )
    ),
    MANAGER(
            Set.of(
                    MANAGER_CREATE,
                    MANAGER_DELETE,
                    MANAGER_UPDATE,
                    MANAGER_READ
            )
    )
    ;

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = new ArrayList<>(this.getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
