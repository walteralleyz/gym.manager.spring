package com.walteralleyz.gymmanager.dto.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.walteralleyz.gymmanager.entities.Plan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate created;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expires;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Plan plan;
}
