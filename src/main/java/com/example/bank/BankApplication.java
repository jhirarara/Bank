package com.example.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class BankApplication {
    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
        String name = "ReportSubmissionFileUpload_History";
        List<String> k = Arrays.asList(
                "InternalId",
                "ReportSubmissionFileUploadId",
                "DocEntry",
                "ReportTypeId",
                "FileTypeId",
                "FileTypeAbbreviation",
                "SubmissionDate",
                "FileName",
                "FilePath",
                "FileExtension",
                "FileSize",
                "MimeType",
                "ReportTypeCode",
                "StatusId",
                "StatusName",
                "ActionId",
                "UserSign",
                "Timestamp",
                "InstanceId"
        );



        // Add "hello" to each element
        List<String> result = k.stream()
                .map(s -> "create index " + s +" on "+name+" "+"("+s+");")  // Concatenate "hello" with each element
                .collect(Collectors.toList());



        // Print the result
        result.forEach(System.out::println);

    }
}
