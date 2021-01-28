package com.walteralleyz.gymmanager.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.walteralleyz.gymmanager.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    private String username;

    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 16)
    private String password;

    @NotNull
    private Long roleId;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Role role;
}
