package com.araby.accounts.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountsDto {

    @NotNull(message = "Account number cannot be null")
    @Min(value = 1000000000L, message = "Account number must be 10 digits")
    @Max(value = 9999999999L, message = "Account number must be 10 digits")
    private Long accountNumber;

    @Size(max = 50, message = "Account type cannot exceed 100 characters")
    private String accountType;

    @Size(max = 200, message = "Branch address cannot exceed 200 characters")
    private String branchAddress;
}
