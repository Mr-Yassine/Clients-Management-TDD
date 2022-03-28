package com.youcode.clientsmanagement.repositories;

import com.youcode.clientsmanagement.entities.Client;
import com.youcode.clientsmanagement.enums.SexEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByIdOrSexOrEmail(Optional<Long> id, Optional<SexEnum> sex,Optional<String> email);
    Page<Client> findAllByIsActiveTrue(Pageable page);

}
