package com.abel.investors.repositories;

import com.abel.investors.models.Account;
import com.abel.investors.models.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, UUID> {
    List<BillingAddress> findAllByAccount(Account account);
}
