package com.walteralleyz.gymmanager.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.walteralleyz.gymmanager.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotBlank
    @Size(min = 4, max = 30)
    private String name;

    @NotNull
    @Email
    private String email;

    @NotEmpty
    @NotBlank
    @Size(min = 8, max = 16)
    private String password;

    @Pattern(regexp = "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$")
    private String phone;

    @NotNull
    private Long roleId;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Role role;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate created;
}
