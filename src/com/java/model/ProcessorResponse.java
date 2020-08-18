package com.java.model;

public class ProcessorResponse {
  private String accountNumber;
  private boolean isValid;

  public ProcessorResponse(String accountNumber, boolean isValid) {
    this.accountNumber = accountNumber;
    this.isValid = isValid;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public boolean isValid() {
    return isValid;
  }

  public void setValid(boolean valid) {
    isValid = valid;
  }
}
