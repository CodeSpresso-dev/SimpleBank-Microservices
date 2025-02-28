package mehdi.sample.microservices.samplebank.loans.mapper;

import mehdi.sample.microservices.samplebank.loans.dto.LoansDto;
import mehdi.sample.microservices.samplebank.loans.entity.Loans;
import org.springframework.beans.BeanUtils;

public class LoansMapper {

    public static LoansDto mapToLoansDto(Loans loans, LoansDto loansDto) {
//        loansDto.setLoanNumber(loans.getLoanNumber());
//        loansDto.setLoanType(loans.getLoanType());
//        loansDto.setMobileNumber(loans.getMobileNumber());
//        loansDto.setTotalLoan(loans.getTotalLoan());
//        loansDto.setAmountPaid(loans.getAmountPaid());
//        loansDto.setOutstandingAmount(loans.getOutstandingAmount());
        BeanUtils.copyProperties(loans, loansDto);
        return loansDto;
    }

    public static Loans mapToLoans(LoansDto loansDto, Loans loans) {
//        loans.setLoanNumber(loansDto.getLoanNumber());
//        loans.setLoanType(loansDto.getLoanType());
//        loans.setMobileNumber(loansDto.getMobileNumber());
//        loans.setTotalLoan(loansDto.getTotalLoan());
//        loans.setAmountPaid(loansDto.getAmountPaid());
//        loans.setOutstandingAmount(loansDto.getOutstandingAmount());
        BeanUtils.copyProperties(loansDto, loans);
        return loans;
    }
}
