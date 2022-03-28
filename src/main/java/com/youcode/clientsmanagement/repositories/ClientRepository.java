package com.youcode.clientsmanagement.repositories;

import com.youcode.clientsmanagement.entities.Client;
import com.youcode.clientsmanagement.enums.SexEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
/*    @Query(value= "select *  FROM clients WHERE sex LIKE :sex OR email LIKE :email", nativeQuery = true)
      Optional<Client> findByChoice(@Param("email") String email,@Param("sex") SexEnum sex);
*/
    List<Client> findByIdOrSexOrEmail(Optional<Long> id, Optional<SexEnum> sex,Optional<String> email);

}
