package com.example.sc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Details {

    private int details_id;
    @NotBlank(message = "Заполните поле")
    private String name_detail;
    @NotNull(message = "Заполните поле")
    private Integer price_detail;
    private Integer ord_id;
}
