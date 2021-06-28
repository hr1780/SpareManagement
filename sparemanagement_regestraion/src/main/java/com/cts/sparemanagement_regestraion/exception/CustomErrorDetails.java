package com.cts.sparemanagement_regestraion.exception;

import lombok.Data;

import java.util.Date;

@Data
public class CustomErrorDetails {

    Date timestamp;
    String message ;
    String details;

    public CustomErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
