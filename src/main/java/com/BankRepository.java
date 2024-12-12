
package com.example.Konain_FinlTest_COMP303.repository;

import com.example.Konain_FinlTest_COMP303.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    // Custom queries
    Bank findByBankName(String bankName);

    Bank findByBankId(Long bankId);
}
