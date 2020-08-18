package com.java.model;

public class Account {
  private String accountNumber;

  public Account(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }
}
