package com.example.Database;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    public LocalDateTime createDT(int year, int month, int day, int hour, int minute){
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public LocalDateTime toDateTime(String str){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }

    public String toString (LocalDateTime dt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = dt.format(formatter);
        return formattedDateTime;
    }

    
}
