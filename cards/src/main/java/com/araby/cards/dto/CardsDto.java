package com.araby.cards.dto;

import com.araby.cards.constants.CardsConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(
        name = "Cards",
        description = "Schema to hold Card information"
)
@Data
public class CardsDto {

    @Schema(
            description = "Mobile number of Customer",
            example = "01120029983"
    )
    @NotBlank(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = CardsConstants.EGYPTIAN_MOBILE_REGEX, message = CardsConstants.EGYPTIAN_MOBILE_MESSAGE)
    private String mobileNumber;

    @Schema(
            description = "Card number of the customer",
            example = "100646930341"
    )
    @NotBlank(message = "Card number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "CardNumber must be 12 digits")
    private String cardNumber;

    @Schema(
            description = "Type of the card",
            example = "Credit Card"
    )
    @NotBlank(message = "CardType cannot be null or empty")
    @Size(max = 100, message = "Card type cannot exceed 100 characters")
    private String cardType;

    @Schema(
            description = "Total amount limit available against a card",
            example = "100000"
    )
    @Positive(message = "Total card limit should be greater than zero")
    private int totalLimit;

    @Schema(
            description = "Total amount used by a Customer",
            example = "1000"
    )
    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    private int amountUsed;

    @Schema(
            description = "Total available amount against a card",
            example = "99000"
    )
    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    private int availableAmount;

}
