package com.youcode.clientsmanagement.services;

import com.youcode.clientsmanagement.entities.Client;
import com.youcode.clientsmanagement.enums.SexEnum;
import com.youcode.clientsmanagement.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;



    @BeforeEach
    void setUp(){
        clientService = new ClientService(clientRepository);
    }

    Client client1 = new Client(1L, "c1",22,"c1@gmail.com","+212611223344", SexEnum.Male,true);
    Client client2 = new Client(1L, "c1",22,"c1@gmail.com","+212611223344", SexEnum.Male,true);
    List<Client> clients = new ArrayList<>();


    @Test
    void getClientBychoice() {
        clients.add(client1);
        clients.add(client2);
        Mockito.when(clientService.getClientBychoice(Optional.of(1L),Optional.of(client1.getEmail()),Optional.of(SexEnum.Male))).thenReturn(clients);
        assertThat(clientService.getClientBychoice(Optional.of(1L),Optional.of(client1.getEmail()),Optional.of(SexEnum.Male))).isNotNull();
    }

    @Test
    void getClients() {
        clients.add(client1);
        clients.add(client2);
        Mockito.when(clientService.getClients()).thenReturn(clients);
        assertThat(clientService.getClients()).isNotNull();
    }

    @Test
    void saveClient() {
        Mockito.when(clientService.saveClient(client1))
                .thenReturn(client1);
        assertThat(clientService.saveClient(client1)).isEqualTo(client1);
    }

    @Test
    void updateClient() {
        Mockito.lenient().when(clientRepository.findById(1L)).thenReturn(Optional.of(client1));
        Mockito.when(clientService.updateClient(client1))
                .thenReturn(client1);
        assertThat(clientService.updateClient(client1).getName()).isEqualTo("c1");
    }

    @Test
    void deleteClient() {
        assertThat(clientService.deleteClient(client1.getId())).isEqualTo("Client removed successfully");
    }
}
