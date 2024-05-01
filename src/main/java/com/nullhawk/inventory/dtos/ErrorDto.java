package com.nullhawk.inventory.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
    private int errorCode;
    private String errorMessage;
}
