package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entity.Account;

@EnableJpaRepositories
public interface AccountRepository extends JpaRepository<Account, Integer>{

      // Account findByAccountNumber(String accountNo);
}
