package com.java;

import com.java.model.Account;
import com.java.model.ProcessorResponse;

import java.util.ArrayList;
import java.util.List;

public class LuhnProcessor {
  public List<ProcessorResponse> getValidLuhnNumber(List<Account> accountList) {
    if (accountList == null) {
      System.out.println("Account List is null/empty.");
    }

    List<ProcessorResponse> response = new ArrayList<>();
    accountList.stream().forEach(x -> response.add(validate(x.getAccountNumber())));

    return response;
  }

  private ProcessorResponse validate(String data) {
    int nDigits = data.length();

    int nSum = 0;
    boolean isSecond = false;
    for (int i = nDigits - 1; i >= 0; i--)
    {

      int d = data.charAt(i) - '0';

      if (isSecond == true) {
        d = d * 2;
      }


      // We add two digits to handle
      // cases that make two digits
      // after doubling
      nSum += d / 10;
      nSum += d % 10;

      isSecond = !isSecond;
    }

    return new ProcessorResponse(data, (nSum % 10 == 0));
  }
}
