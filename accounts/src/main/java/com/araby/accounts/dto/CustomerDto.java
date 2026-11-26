package com.araby.accounts.dto;

import com.araby.accounts.constants.AccountsConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDto {

    @NotBlank(message = "Name cannot be null or empty")
    @Size(min = 2, max = 100, message = "The length of the customer name should be between 2 and 100")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Name should contain only letters and valid name characters")
    private String name;

    @NotBlank(message = "Email address cannot be null or empty")
    @Email(message = "Email address should be a valid value")
    @Size(max = 100, message = "Email address cannot exceed 100 characters")
    private String email;

    @NotBlank(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = AccountsConstants.EGYPTIAN_MOBILE_REGEX, message = AccountsConstants.EGYPTIAN_MOBILE_MESSAGE)
    private String mobileNumber;

    private AccountsDto accountsDto;

}
