package com.youcode.clientsmanagement.services;


import com.youcode.clientsmanagement.entities.Client;
import com.youcode.clientsmanagement.enums.SexEnum;
import com.youcode.clientsmanagement.exceptions.ApiRequestException;
import com.youcode.clientsmanagement.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    //Get methods
    public List<Client> getClientBychoice(Optional<Long> id, Optional<String> email, Optional<SexEnum> sex) {
        List<Client> client = clientRepository.findByIdOrSexOrEmail(id,sex,email);
        if (client!=null){
            return  client;
        } else {
            throw new ApiRequestException("There is no client with these information");
        }
    }
    public List<Client> getClients() {
        List<Client> clients = (List<Client>) clientRepository.findAll();
        if (clients != null){
            return clients;
        } else {
            throw new ApiRequestException("There is no client with these information");
        }
    }


    //Post method
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }



    //Put method
    public Client updateClient (Client client){
        Client existingClient = clientRepository.findById(client.getId()).orElse(null);

        if(existingClient!=null){
            return clientRepository.save(client);
        }
        return client;
    }


    //Delete method
    public String deleteClient(Long id){
        clientRepository.deleteById(id);
        return "Client removed successfully";
    }
}
