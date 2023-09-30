package com.mch.contactmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private String timestampDateTime;
    private String message;
    private String details;
}
