package com.walteralleyz.gymmanager.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotBlank
    @Size(min = 4, max = 30)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    private double weight;

    @NotNull
    private double height;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @NotNull
    private String createdAt;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @NotNull
    private String expireTime;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Plan plan;
}
