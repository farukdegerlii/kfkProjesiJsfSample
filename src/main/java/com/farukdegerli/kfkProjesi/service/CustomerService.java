package com.farukdegerli.kfkProjesi.service;


import com.farukdegerli.kfkProjesi.dto.CustomerReadDto;
import com.farukdegerli.kfkProjesi.dto.CustomerWriteDto;
import com.farukdegerli.kfkProjesi.dto.Search;
import com.farukdegerli.kfkProjesi.util.MyPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    CustomerReadDto getById(Long id);
    CustomerReadDto save(CustomerWriteDto customerWriteDto);
    CustomerReadDto update(CustomerWriteDto customerWriteDto,Long id);
    Boolean delete(Long id);
    MyPage<CustomerReadDto> searchAll(Pageable pageable, Search search);
    List<CustomerReadDto> findAll();
}
