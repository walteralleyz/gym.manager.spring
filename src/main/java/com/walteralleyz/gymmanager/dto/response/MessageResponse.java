package com.walteralleyz.gymmanager.dto.response;

import lombok.Data;

@Data
public class MessageResponse {
    private String message;

    public MessageResponse(String message, String type) {
        this.message = type + ": " + message;
    }
}
