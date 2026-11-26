package com.araby.loans.mapper;

import com.araby.loans.dto.LoansDto;
import com.araby.loans.entity.Loans;

public class LoansMapper {

    public static LoansDto mapToLoansDto(Loans loans) {
        LoansDto loansDto = new LoansDto();
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        return loansDto;
    }

    public static Loans mapToLoans(LoansDto loansDto, Loans loans) {
        if (loansDto.getLoanNumber() != null) {
            loans.setLoanNumber(loansDto.getLoanNumber());
        }
        if (loansDto.getLoanType() != null) {
            loans.setLoanType(loansDto.getLoanType());
        }
        if (loansDto.getMobileNumber() != null) {
            loans.setMobileNumber(loansDto.getMobileNumber());
        }
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        return loans;
    }

}
