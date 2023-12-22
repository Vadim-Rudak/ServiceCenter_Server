package com.example.sc.entity;


import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.lang.NonNullFields;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.Collections;

//@Entity(name = "ord")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Ord {

    @Id
    private int id;

    @NotBlank(message = "Заполните поле")
    @Length(max = 255,message = "Недопустимое колличество символов")
    private String name_ord;
    @NotBlank(message = "Заполните поле")
    private String date_add_ord;
    private int price;
    @NotBlank(message = "Заполните поле")
    private String breakdown_info;


    private int status_id;
    private int infoclient_id;
    private int warranty_id;

    @Valid
    public Client client;
    private Details details;
    @Valid
    private Status status;
    @Valid
    private Warranty warranty;



//    @OneToOne(mappedBy = "ord", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
//    private Client client;

    //    public Ord(int z,String name, int num_month, int num_day, int price, String breakdown_info) {
//        super();
//        Integer[] arr = new Integer[1000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//        }
//        Collections.shuffle(Arrays.asList(arr));
//        this.id = arr[z];
//        this.name = name;
//        this.num_month = num_month;
//        this.num_day = num_day;
//        this.price = price;
//        this.breakdown_info = breakdown_info;
//    }


}
