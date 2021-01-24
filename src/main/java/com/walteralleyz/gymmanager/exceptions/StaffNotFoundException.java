package com.walteralleyz.gymmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StaffNotFoundException extends Exception {
    public StaffNotFoundException(Long id) {
        super(String.format("Staff com id %s não encontrado!", id));
    }
}
