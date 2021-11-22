package com.farukdegerli.kfkProjesi.view;

import com.farukdegerli.kfkProjesi.dto.CustomerReadDto;
import com.farukdegerli.kfkProjesi.dto.CustomerWriteDto;
import com.farukdegerli.kfkProjesi.dto.Search;
import com.farukdegerli.kfkProjesi.service.CustomerService;
import com.farukdegerli.kfkProjesi.service.impl.CustomerServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@ViewScoped

@Data
@Named
@Component
@Controller
@EnableAutoConfiguration
public class CustomerView implements Serializable {


    public CustomerView() {

    }

    private CustomerService customerService;

    private Long id;
    private CustomerReadDto readDto;
    private CustomerWriteDto writeDto;
    private List<CustomerReadDto> readDtos;
    private Search search;




    public void showCustomer(){
        readDto = customerService.getById(id);
    }

    public void edit(CustomerReadDto readDto) {
        this.readDto=readDto;
    }

    public void fetchAll() {
        readDtos = customerService.findAll();
    }

    public void save() {
        customerService.save(writeDto);
    }



    public void refresh() {

        readDtos = new ArrayList<>();
        readDto = new CustomerReadDto();
        id = null;
        writeDto =new CustomerWriteDto();
        search = new Search();

    }
    public String kayit(){
        id=5L;
        return "customer";
    }


}
