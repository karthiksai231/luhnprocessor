package com.java;

import com.java.model.Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVProcessor {
  private static final String LINE_SEPARATOR = ",";

  public List<Account> getAccountNumbersFromCsv(String fileName) {
    List<Account> accountList = new ArrayList<>();
    Path pathToFile = Paths.get(fileName);
    String currLine = "";

    try (BufferedReader br = Files.newBufferedReader(pathToFile,
        StandardCharsets.US_ASCII)) {
      while ((currLine = br.readLine()) != null) {
        String[] row = currLine.split(LINE_SEPARATOR);
        Account account = mapToAccount(row);
        accountList.add(account);
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    return accountList;
  }

  private Account mapToAccount(String... data) {
    String accNum = data[0];
    return new Account(accNum);
  }
}
