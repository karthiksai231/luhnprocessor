package com.java;

import com.java.model.Account;
import com.java.model.ProcessorResponse;

import java.nio.file.FileSystems;
import java.text.MessageFormat;
import java.util.List;

public class Main {
    private static final String SOURCE_FILE_PATH = "/src/com/java/resources/AccountNumbers.csv";

    public static void main(String... args) {
        // Getting data from CSV file
        String currentDirectory = FileSystems.getDefault()
            .getPath("")
            .toAbsolutePath()
            .toString();
        CSVProcessor csvProcessor = new CSVProcessor();
        List<Account> accounts = csvProcessor
            .getAccountNumbersFromCsv(currentDirectory + SOURCE_FILE_PATH);

        // Validating account number
        LuhnProcessor luhnProcessor = new LuhnProcessor();
        List<ProcessorResponse> responseList = luhnProcessor.getValidLuhnNumber(accounts);

        responseList.stream().forEach(x ->
            System.out.println(MessageFormat.format("{0} is a {1} Luhn Number and the result is {2}",
                x.getAccountNumber(),
                x.isValid() ? "valid" : "invalid", x.getResultNumber())));
    }
}
