package com.araby.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {

    @Schema(
            description = "API path invoked by client",
            example = "uri=/api/fetch"
    )
    private String apiPath;

    @Schema(
            description = "Error code representing the error happened",
            example = "NOT_FOUND"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message representing the error happened",
            example = "Card not found with the given input data mobileNumber : '01012345678'"
    )
    private String errorMessage;

    @Schema(
            description = "Time representing when the error happened",
            example = "2026-11-26T16:45:00"
    )
    private LocalDateTime errorTime;

}
