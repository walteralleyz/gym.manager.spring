package com.walteralleyz.gymmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoleNotFoundException extends Exception {
    public RoleNotFoundException(Long id) {
        super(String.format("Role id %s not found", id));
    }
}
