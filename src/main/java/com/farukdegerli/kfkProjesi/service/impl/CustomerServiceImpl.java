package com.farukdegerli.kfkProjesi.service.impl;

import com.farukdegerli.kfkProjesi.SearchPackage.SearchCriteria;
import com.farukdegerli.kfkProjesi.SearchPackage.SearchSpec;
import com.farukdegerli.kfkProjesi.domain.Customer;
import com.farukdegerli.kfkProjesi.dto.CustomerReadDto;
import com.farukdegerli.kfkProjesi.dto.CustomerWriteDto;
import com.farukdegerli.kfkProjesi.dto.Search;
import com.farukdegerli.kfkProjesi.repository.CustomerRepository;
import com.farukdegerli.kfkProjesi.service.CustomerService;
import com.farukdegerli.kfkProjesi.util.MyPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public CustomerReadDto getById(Long id){
        try {
            return convertDomainToDto(customerRepository.getById(id));
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    @Override
    public CustomerReadDto save(CustomerWriteDto customerWriteDto) {
        try {
            return convertDomainToDto(customerRepository.save(convertDtoToDomain(customerWriteDto)));
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    @Override
    public CustomerReadDto update(CustomerWriteDto customerWriteDto,Long id) {
        if(!customerRepository.getById(id).equals(null)){
            try {
                Customer customer = convertDtoToDomain(customerWriteDto);
                customer.setId(id);
                return convertDomainToDto(customerRepository.save(customer));
            }catch (Exception e){
                throw new IllegalArgumentException(e.getMessage());
            }

        }else {
            throw new IllegalArgumentException("Db has not this Customer");
        }

    }

    @Override
    public Boolean delete(Long id) {
        try {
            customerRepository.delete(customerRepository.getById(id));
            return !customerRepository.existsById(id);
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public MyPage<CustomerReadDto> searchAll(Pageable pageable, Search search) {
        SearchSpec spesification = new SearchSpec<Customer>();
        spesification.add(new SearchCriteria("name", search.getName()));
        spesification.add(new SearchCriteria("surname", search.getSurname()));
        spesification.add(new SearchCriteria("legalId", search.getLegalId()));
        spesification.add(new SearchCriteria("telephoneNumber", search.getTelephoneNumber()));
        spesification.add(new SearchCriteria("address", search.getAddress()));

        Page<CustomerReadDto> customerReadDtos;
        customerReadDtos = customerRepository.findAll(spesification, pageable).map(this::convertDomainToDto);
        MyPage<CustomerReadDto> myPage =new MyPage();
        myPage.setStat(customerReadDtos, Arrays.asList(modelMapper.map(customerReadDtos.getContent(),CustomerReadDto[].class)));

        return myPage;
    }

    @Override
    public List<CustomerReadDto> findAll() {
        List<CustomerReadDto> readDtos = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> readDtos.add(convertDomainToDto(customer)));
        return readDtos;
    }

    private CustomerReadDto convertDomainToDto(Object o) {
        return modelMapper.map(o,CustomerReadDto.class);
    }

    public Customer convertDtoToDomain(CustomerWriteDto customer){
        return modelMapper.map(customer,Customer.class);
    }
}
