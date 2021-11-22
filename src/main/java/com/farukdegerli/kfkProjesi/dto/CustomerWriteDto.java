package com.farukdegerli.kfkProjesi.dto;

import lombok.Data;

@Data
public class CustomerWriteDto {

    private String name;
    private String surname;
    private String legalId;
    private String telephoneNumber;
    private String address;
}
