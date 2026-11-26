package com.araby.loans.constants;

public final class LoansConstants {

    private LoansConstants() {
        // restrict instantiation
    }

    public static final String HOME_LOAN = "Home Loan";
    public static final int NEW_LOAN_LIMIT = 1_00_000;
    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "Loan created successfully";
    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";
    public static final String STATUS_417 = "417";
    public static final String MESSAGE_417_UPDATE = "Update operation failed. Please try again or contact Dev team";
    public static final String MESSAGE_417_DELETE = "Delete operation failed. Please try again or contact Dev team";
    public static final String EGYPTIAN_MOBILE_REGEX = "^(?:01[0125][0-9]{8}|\\+201[0125][0-9]{8}|00201[0125][0-9]{8})$";
    public static final String EGYPTIAN_MOBILE_MESSAGE = "Mobile number must be a valid Egyptian mobile number (e.g. 01012345678, +201012345678, or 00201012345678)";

}
