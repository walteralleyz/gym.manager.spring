package com.walteralleyz.gymmanager.dto.request;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.walteralleyz.gymmanager.entities.Plan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    @Id
    private Long id;

    @NotEmpty
    @NotBlank
    @Size(min = 4, max = 30)
    private String name;

    @Email
    @NotNull
    private String email;

    @NotNull
    private double weight;

    @NotNull
    private double height;

    @NotNull
    private Long planId;

    @NotNull
    @DateTimeFormat
    private String created;

    @NotNull
    @DateTimeFormat
    private String expires;

    @JsonIgnore
    private Plan plan;
}
