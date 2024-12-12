
package com.example.Konain_FinlTest_COMP303.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BankID")
    private Long bankId; // Primary key, auto-generated

    @NotNull
    @Size(min = 2, max = 100)
    @Column(name = "BankName")
    private String bankName; // Bank name

    @NotNull
    @Min(value = 1000)  // assuming a bank can't be established before the year 1000
    @Column(name = "BankYear")
    private int bankYear; // Year bank was established

    @NotNull
    @Min(value = 1)  // A bank must have at least one employee
    @Column(name = "BankEmp")
    private int bankEmp; // Number of employees

    @NotNull
    @Size(min = 5, max = 255)
    @Column(name = "BankAddress")
    private String bankAddress; // Complete address of the bank

    @NotNull
    @Min(value = 1) // A bank must have at least one branch
    @Column(name = "BankBranches")
    private int bankBranches; // Number of branches

    @NotNull
    @Min(value = 1) // A bank must have at least one ATM
    @Column(name = "BankATMs")
    private int bankATMs; // Number of ATMs

    // Getters and Setters
    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankYear() {
        return bankYear;
    }

    public void setBankYear(int bankYear) {
        this.bankYear = bankYear;
    }

    public int getBankEmp() {
        return bankEmp;
    }

    public void setBankEmp(int bankEmp) {
        this.bankEmp = bankEmp;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public int getBankBranches() {
        return bankBranches;
    }

    public void setBankBranches(int bankBranches) {
        this.bankBranches = bankBranches;
    }

    public int getBankATMs() {
        return bankATMs;
    }

    public void setBankATMs(int bankATMs) {
        this.bankATMs = bankATMs;
    }
}

