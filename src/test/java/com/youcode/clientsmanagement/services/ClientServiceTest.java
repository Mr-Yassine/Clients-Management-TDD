package com.youcode.clientsmanagement.services;

import com.youcode.clientsmanagement.entities.Client;
import com.youcode.clientsmanagement.enums.SexEnum;
import com.youcode.clientsmanagement.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    ClientRepository clientRepository;
    @InjectMocks
    ClientService clientService;


    Client client;

    @BeforeEach
    void initClient(){
        client = new Client(1L, "name", 22, "bilal@gmail.com", "+212653123456", SexEnum.Male, true);
    }


    @Test
    void saveClient() {
        Mockito.lenient().when(clientRepository.save(client)).thenReturn(client);
        // Mockito.when(clientService.saveClient(client)).thenReturn(client);
        Client client1= clientService.saveClient(client);
        System.out.println(client);
        System.out.println(client1);
        assertThat(client).isEqualTo(client1);
    }
    @Test

    void getClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(client);

        given(clientRepository.findAll()).willReturn(clients);

        List<Client> clients2 = clientService.getClients();

        assertEquals(clients2, clients);

        //to verify
        verify(clientRepository).findAll();
    }

    @Test
    void getClientById() {
        // doReturn(Optional.of(client)).when(clientRepositoryI).findById(1L);
        Mockito.lenient().when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        //Mockito.when(clientService.getClientById(1L)).thenReturn(client);
        Client client1= clientService.getClientById(1L);
        assertThat(client1).isEqualTo(client);
    }

    @Test
    void deleteClient() {
        Mockito.lenient().when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        clientService.deleteClient(client.getId());

    }

    @Test
    void updateClient() {
        Mockito.lenient().when(clientRepository.findById(1L)).thenReturn(Optional.of(client));
        Mockito.lenient().when(clientRepository.save(client)).thenReturn(client);
        Client client1= clientService.updateClient(client);
        assertThat(client).isEqualTo(client1);
    }



}
