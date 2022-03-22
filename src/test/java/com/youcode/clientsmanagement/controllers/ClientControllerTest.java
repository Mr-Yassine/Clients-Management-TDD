package com.youcode.clientsmanagement.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.youcode.clientsmanagement.entities.Client;
import com.youcode.clientsmanagement.enums.SexEnum;
import com.youcode.clientsmanagement.services.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@RunWith(MockitoJUnitRunner.Silent.class)
@WebMvcTest(ClientController.class)
class ClientControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClientService clientService;



    @Test
    void findClientByChoice() throws Exception{
        Client client1 = new Client(1L, "c1",22,"c1@gmail.com","+212611223344", SexEnum.Male,true);
        List<Client>clients=new ArrayList<>();
        clients.add(client1);
        when(clientService.getClientBychoice(Optional.of(1L),Optional.of(client1.getEmail()),Optional.of(SexEnum.Male))).thenReturn(clients);
        mockMvc.perform(get("/api/client/id/"+client1.getId()))
                .andExpect(status().isOk());

    }

    @Test
    void getAllClients() throws Exception{
        Client client1 = new Client(1L, "c1",22,"c1@gmail.com","+212611223344", SexEnum.Male,true);
        Client client2 = new Client(2L, "c2",22,"c2@gmail.com","+212699887766", SexEnum.Male,true);
        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        when(clientService.getClients()).thenReturn(clients);
        mockMvc.perform(get("/api/client/all"))
                .andExpect(status().isOk());
    }

    @Test
    void saveClient() throws Exception{
        Client client1 = new Client(1L, "c1",22,"c1@gmail.com","+212611223344", SexEnum.Male,true);
        when(clientService.saveClient(client1))
                .thenReturn(client1);

        mockMvc.perform(post("/api/client/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(client1)))
                .andExpect(status().isOk());
    }

    @Test
    void updateClient() throws Exception{
        Client client1 = new Client(1L, "c1",22,"c1@gmail.com","+212611223344", SexEnum.Male,true);

        when(clientService.saveClient(client1))
                .thenReturn(client1);
        mockMvc.perform(put("/api/client/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(client1)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteClient() throws Exception {
        Client client1 = new Client(1L, "c1",22,"c1@gmail.com","+212611223344", SexEnum.Male,true);
        given(clientService.deleteClient(client1.getId())).willReturn("deleted");

        mockMvc.perform(delete("/api/client/delete/"+client1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
