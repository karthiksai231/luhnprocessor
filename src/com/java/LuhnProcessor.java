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
    List<Integer> l = new ArrayList<>();
    StringBuilder builder = new StringBuilder();

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
      int n1 = d/10;
      int n2 = d%10;

      // Appending Obfuscated number
      builder.append(n1 + n2);

      nSum += d / 10;
      nSum += d % 10;

      isSecond = !isSecond;
    }

    System.out.println("CheckSum: " + nSum);
    String obNumber = builder.reverse().toString();
    System.out.println("Calculated Number: " + obNumber);
    String newCalculatedNumber = obNumber;

    if (nSum % 10 != 0) {
      System.out.println("Since the Check Sum is not valid need to re calculate");
      int currSum = nSum - (obNumber.charAt(obNumber.length() - 1) - '0');

      for (int i = 0; i <= 9; i++) {
        if (i == (data.charAt(data.length() -1) - '0')) {
          continue;
        } else {
          int newSum = currSum + i;
          if (newSum % 10 == 0) {
            System.out.println("New CheckSum: " + newSum);
            System.out.println("The replacement digit is " + i);
            StringBuilder myName = new StringBuilder(obNumber);
            myName.setCharAt((obNumber.charAt(obNumber.length() - 1) - '0'), (char) (i + '0'));
            newCalculatedNumber = myName.toString();
            break;
          }
        }
      }
    }

    return new ProcessorResponse(data, (nSum % 10 == 0), newCalculatedNumber);
  }
}
