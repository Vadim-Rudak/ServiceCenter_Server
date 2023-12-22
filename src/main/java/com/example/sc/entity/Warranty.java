package com.example.sc.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Warranty {

    private int warranty_id;
    @NotBlank(message = "Заполните поле")
    @Length(max = 255,message = "Недопустимое колличество символов")
    private String warranty;
    @NotBlank(message = "Заполните поле")
    private String date_add;
    @NotBlank(message = "Заполните поле")
    private String validity;
}
