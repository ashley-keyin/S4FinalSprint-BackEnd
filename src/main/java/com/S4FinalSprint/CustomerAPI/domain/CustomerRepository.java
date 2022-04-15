package com.S4FinalSprint.CustomerAPI.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstName(@Param("firstName") String firstName);
    List<Customer> findByLastName(@Param("lastName") String lastName);
    List<Customer> findByEmail(@Param("email") String email);
    List<Customer> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
    List<Customer> findByAddress(@Param("address") String address);
    List<Customer> findByCity(@Param("city") String city);
    List<Customer> findByCountry(@Param("country") String country);
    List<Customer> findByAccountBalance(@Param("accountBalance") String accountBalance);
}