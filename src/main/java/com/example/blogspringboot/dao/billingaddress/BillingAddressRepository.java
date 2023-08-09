package com.example.blogspringboot.dao.billingaddress;

import com.example.blogspringboot.entity.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {
    BillingAddress findBillingAddressByIdEquals(Long id);

}
