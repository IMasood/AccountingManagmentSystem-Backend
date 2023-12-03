package com.example.accountingmanagementsystem.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {


    public static Date parseDate(String dateString){
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
