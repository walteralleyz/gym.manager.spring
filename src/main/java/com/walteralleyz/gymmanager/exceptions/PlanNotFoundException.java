package com.walteralleyz.gymmanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlanNotFoundException extends Exception {
    public PlanNotFoundException() {
        super("Plano não encontrado!");
    }
}
