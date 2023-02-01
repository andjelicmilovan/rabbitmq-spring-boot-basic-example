package com.decode.rabbitmq_basic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonDto {
    private int id;
    private String firstName;
    private String lastName;
}
