package com.vektorel.firstproject.repository;

import com.vektorel.firstproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "select * from customer where username= :kullaniciadi"
            ,nativeQuery = true)
    Optional<Customer> myFindByUsername(@Param("kullaniciadi") String username);

    Optional<Customer> findOptionalByUsername(String xf);

}
