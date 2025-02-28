package com.abel.investors.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
public class RestErrorResponse {
    private Instant timestamp;
    private int status;
    private String error;
}
