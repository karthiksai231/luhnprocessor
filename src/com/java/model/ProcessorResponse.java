package com.java.model;

public class ProcessorResponse {
  private String accountNumber;
  private String resultNumber;
  private boolean isValid;

  public ProcessorResponse(String accountNumber, boolean isValid, String resultNumber) {
    this.accountNumber = accountNumber;
    this.isValid = isValid;
    this.resultNumber = resultNumber;
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

  public String getResultNumber() {
    return this.resultNumber;
  }

  public void setResultNumber(String resultNumber) {
    this.resultNumber = resultNumber;
  }
}
