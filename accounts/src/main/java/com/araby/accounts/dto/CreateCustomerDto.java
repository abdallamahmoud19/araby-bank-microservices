package com.araby.accounts.dto;

import com.araby.accounts.constants.AccountsConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "CreateCustomer",
        description = "Schema to hold Customer information when creating a new account"
)
public class CreateCustomerDto {

    @Schema(
            description = "Name of the customer",
            example = "Abdalla Araby"
    )
    @NotBlank(message = "Name cannot be null or empty")
    @Size(min = 2, max = 30, message = "The length of the customer name should be between 2 and 30")
    @Pattern(regexp = "^[\\p{L} .'-]+$", message = "Name should contain only letters and valid name characters")
    private String name;

    @Schema(
            description = "Email address of the customer",
            example = "abdalla@email.com"
    )
    @NotBlank(message = "Email address cannot be null or empty")
    @Email(message = "Email address should be a valid value")
    @Size(max = 100, message = "Email address cannot exceed 100 characters")
    private String email;

    @Schema(
            description = "Mobile number of the customer",
            example = "01120029983"
    )
    @NotBlank(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = AccountsConstants.EGYPTIAN_MOBILE_REGEX, message = AccountsConstants.EGYPTIAN_MOBILE_MESSAGE)
    private String mobileNumber;

}
