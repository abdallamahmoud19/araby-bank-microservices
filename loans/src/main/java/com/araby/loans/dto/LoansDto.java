package com.araby.loans.dto;

import com.araby.loans.constants.LoansConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "Loans",
        description = "Schema to hold Loan information"
)
@Data
public class LoansDto {

    @Schema(
            description = "Mobile number of Customer",
            example = "01120029983"
    )
    @NotBlank(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = LoansConstants.EGYPTIAN_MOBILE_REGEX, message = LoansConstants.EGYPTIAN_MOBILE_MESSAGE)
    private String mobileNumber;

    @Schema(
            description = "Loan number of the customer",
            example = "548732457654"
    )
    @NotBlank(message = "Loan number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "LoanNumber must be 12 digits")
    private String loanNumber;

    @Schema(
            description = "Type of the loan",
            example = "Home Loan"
    )
    @NotBlank(message = "LoanType cannot be null or empty")
    @Size(max = 100, message = "Loan type cannot exceed 100 characters")
    private String loanType;

    @Schema(
            description = "Total loan amount",
            example = "100000"
    )
    @Positive(message = "Total loan amount should be greater than zero")
    private int totalLoan;

    @Schema(
            description = "Total loan amount paid",
            example = "1000"
    )
    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    private int amountPaid;

    @Schema(
            description = "Total outstanding amount against a loan",
            example = "99000"
    )
    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    private int outstandingAmount;

}
