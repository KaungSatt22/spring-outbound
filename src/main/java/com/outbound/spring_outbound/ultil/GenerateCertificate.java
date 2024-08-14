package com.outbound.spring_outbound.ultil;

import java.time.LocalDate;

public class GenerateCertificate {
    public String generateCertificateNumber(int number) {
        LocalDate now = LocalDate.now();
        int month = now.getMonthValue();
        int year = now.getYear();
        String formattedNumber = String.format("ITA/%04d/%02d-%d", number, month, year);
        return formattedNumber;
    }
}
