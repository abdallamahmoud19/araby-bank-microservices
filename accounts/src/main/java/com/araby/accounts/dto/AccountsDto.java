package com.araby.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @Schema(
            description = "Account number of ArabyBank account",
            example = "1234567890"
    )
    @NotNull(message = "Account number cannot be null")
    @Min(value = 1000000000L, message = "Account number must be 10 digits")
    @Max(value = 9999999999L, message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of ArabyBank account",
            example = "Savings"
    )
    @Size(max = 50, message = "Account type cannot exceed 100 characters")
    private String accountType;

    @Schema(
            description = "ArabyBank branch address",
            example = "123 Main Street, New York"
    )
    @Size(max = 200, message = "Branch address cannot exceed 200 characters")
    private String branchAddress;
}
