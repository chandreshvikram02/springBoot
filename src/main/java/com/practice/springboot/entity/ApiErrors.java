package com.practice.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrors {
    String message;
    List<String> details;
    HttpStatus status;
    LocalDateTime timeStamp;
}
