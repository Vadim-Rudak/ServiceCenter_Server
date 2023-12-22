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
public class Status {


    private int status_id;
    @NotBlank(message = "Заполните поле")
    @Length(max = 15,message = "Недопустимое колличество символов")
    private String info_status;
}
