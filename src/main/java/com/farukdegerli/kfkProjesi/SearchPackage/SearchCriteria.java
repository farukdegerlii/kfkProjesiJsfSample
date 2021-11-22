package com.farukdegerli.kfkProjesi.SearchPackage;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class SearchCriteria {
    private String key;
    private Object value;


    public SearchCriteria(String key, Object value) {
        this.key = key;
        this.value = value;
    }
}

