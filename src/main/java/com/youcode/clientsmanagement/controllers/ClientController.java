package com.youcode.clientsmanagement.controllers;


import com.youcode.clientsmanagement.entities.Client;
import com.youcode.clientsmanagement.enums.SexEnum;
import com.youcode.clientsmanagement.exceptions.ApiExceptionHandler;
import com.youcode.clientsmanagement.exceptions.ApiRequestException;
import com.youcode.clientsmanagement.services.ClientService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/client")
public class ClientController{

    private final ClientService clientService;


    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    //Get methods
    @GetMapping(value={"/id/{id}", "/email/{email}","/sex/{sex}","/{sex}/{email}"})
    public List<Client> findClientByChoice(@PathVariable(value = "id",required = false)  Optional<Long>  id, @PathVariable(value = "email",required = false)  Optional<String>  email, @PathVariable(value = "sex",required = false) Optional<SexEnum> sex){
        return clientService.getClientBychoice(id, email, sex);
    }
    @GetMapping("/all")
    public List<Client> getAllClients() throws Exception{
        return clientService.getClients();
    }



    //Post method
    @PostMapping("/add")
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }


    //Put method
    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }


    //Delete method
    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable long id){
        return clientService.deleteClient(id);
    }


}
