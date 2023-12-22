package com.example.sc.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Entity(name = "infoclient")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Client {


    @Id
    private int infoclient_id;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Ord_id")
//    private Ord ord;

    @NotBlank(message = "Заполните поле")
    @Length(max = 15,message = "Недопустимое колличество символов")
    private String surname;
    @NotBlank(message = "Заполните поле")
    @Length(max = 15,message = "Недопустимое колличество символов")
    private String name;
    @NotBlank(message = "Заполните поле")
    @Length(max = 15,message = "Недопустимое колличество символов")
    private String patronymic;
    @NotBlank(message = "Заполните поле")
    private String address;
    @NotNull(message = "Заполните поле")
    private Integer phone_number;
}
