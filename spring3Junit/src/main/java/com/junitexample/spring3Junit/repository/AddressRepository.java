package com.junitexample.spring3Junit.repository;

import com.junitexample.spring3Junit.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findById(Long id);
    Optional<Address> findByCity(String city);
}
