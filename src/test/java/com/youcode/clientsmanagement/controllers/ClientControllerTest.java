package com.youcode.clientsmanagement.controllers;

import com.youcode.clientsmanagement.entities.Client;
import com.youcode.clientsmanagement.enums.SexEnum;
import com.youcode.clientsmanagement.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@WebMvcTest(ClientControllerTest.class)
@ExtendWith(MockitoExtension.class)
class ClientControllerTest {


    @MockBean
    private ClientService clientService;

    @Autowired
    private MockMvc mockMvc;


    @InjectMocks
    ClientController clientController;
    Client client;


    @BeforeEach
    void initClient(){
        client = new Client(1L, "name", 22, "bilal@gmail.com", "+212653123456", SexEnum.Male, true);
    }


    @Test
    void getAllClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(client);

        given(clientService.getClients()).willReturn(clients);

    }

    @Test
    void findClientById() {
    }


    @Test
    void saveClient() {
    }

    @Test
    void updateClient() {
    }

    @Test
    void deleteClient() {
    }
}
