package com.destaproject.common.infrastructure.web.response;

import com.destaproject.common.infrastructure.utility.TimeUtility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseData<T> {

    private Integer code;
    private HttpStatus status;
    private String message;
    private List<T> messageError;
    private T error;
    private MetadataResponse metadata;
    private T data;
    private String token;
    private final Timestamp requestOn = TimeUtility.getTimestampByLocalDateTime();
}