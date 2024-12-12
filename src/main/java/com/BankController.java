package com.example.Konain_FinlTest_COMP303.controller;

import com.example.Konain_FinlTest_COMP303.model.Bank;
import com.example.Konain_FinlTest_COMP303.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    @Autowired
    private BankRepository bankRepository;

    // Create a new bank
    @PostMapping
    public Bank createBank(@RequestBody Bank bank) {
        return bankRepository.save(bank);
    }

    // Get a bank by BankID
    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable("id") Long id) {
        Optional<Bank> bank = bankRepository.findById(id);
        return bank.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get a bank by BankName
    @GetMapping("/name/{bankName}")
    public ResponseEntity<Bank> getBankByName(@PathVariable("bankName") String bankName) {
        Bank bank = bankRepository.findByBankName(bankName);
        return bank != null ? ResponseEntity.ok(bank) : ResponseEntity.notFound().build();
    }

    // Get all banks
    @GetMapping
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    // Delete a bank by BankID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable("id") Long id) {
        if (bankRepository.existsById(id)) {
            bankRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Update a bank by BankID
    @PutMapping("/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable("id") Long id, @RequestBody Bank updatedBank) {
        if (bankRepository.existsById(id)) {
            updatedBank.setBankId(id);
            bankRepository.save(updatedBank);
            return ResponseEntity.ok(updatedBank);
        }
        return ResponseEntity.notFound().build();
    }
}
