package com.youcode.clientsmanagement.repositories;

import com.youcode.clientsmanagement.entities.Client;
import com.youcode.clientsmanagement.enums.SexEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ClientRepositoryTest {

    @Mock
    private ClientRepository clientRepository;

    @Test
    void findByIdOrSexOrEmail() {
        Client client1 = new Client(1L, "c1",22,"c1@gmail.com","+212611223344", SexEnum.Male,true);
        List<Client> clients = new ArrayList<>();

        Mockito.when(clientRepository.findById(client1.getId())).thenReturn(Optional.of(client1));
        assertThat(clientRepository.findById(client1.getId())).isNotNull();
    }
}
