package com.profile.matcher.service.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ServiceException extends Throwable {

    private final HttpStatus statusCode;
    private final String message;
}
