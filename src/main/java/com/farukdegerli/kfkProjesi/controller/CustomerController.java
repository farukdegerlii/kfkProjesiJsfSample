/*
package com.farukdegerli.kfkProjesi.controller;


import com.farukdegerli.kfkProjesi.dto.CustomerReadDto;
import com.farukdegerli.kfkProjesi.dto.CustomerWriteDto;
import com.farukdegerli.kfkProjesi.dto.Search;
import com.farukdegerli.kfkProjesi.service.CustomerService;
import com.farukdegerli.kfkProjesi.util.MyPage;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("customer-service")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerReadDto> getById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(customerService.getById(id));
    }

    @PostMapping("/save")

    public ResponseEntity<CustomerReadDto> createItem(@Valid @RequestBody CustomerWriteDto customerWriteDto) {

        return ResponseEntity.ok(customerService.save(customerWriteDto));
    }

    @PutMapping("/update")

    public ResponseEntity<CustomerReadDto> updateItem(@Valid @RequestBody CustomerWriteDto customerWriteDto,
                                                      @Param(value = "id") Long id) {

        return ResponseEntity.ok(customerService.update(customerWriteDto,id));
    }
    @DeleteMapping("/{id}")

    public ResponseEntity<Boolean> deleteItem(@PathVariable(value = "id") Long id) {

        return ResponseEntity.ok(customerService.delete(id));
    }
    @GetMapping("/Search")
    public ResponseEntity<MyPage<CustomerReadDto>> getById(Pageable pageable,
                                                           @RequestBody Search search) {

        return ResponseEntity.ok(customerService.searchAll(pageable,search));
    }

}
*/
