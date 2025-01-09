package com.project.FocusFlow.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name(); // Возвращает "ROLE_USER" или "ROLE_ADMIN"
    }
}