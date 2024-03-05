package com.dareshuri.libralink.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.LoanDetail;

@Service()
public interface LoanDetailService {
    
    // CREATE
    LoanDetail addLoanDetail(LoanDetail loanDetail);

    // READ
    Iterable<LoanDetail> getAllLoanDetails();
    Optional<LoanDetail> getLoanDetailById(Long loanId);
    List<LoanDetail> getLoanDetailByUserId(Long userId);

    // UPDATE
    LoanDetail updateReturnDateById(Long loanId, Map<String, String> loanDetailMap) throws ParseException;
    LoanDetail updateStatusById(Long loanId, Map<String, String> loanDetailMap);
    
    // DELETE
    Map<String,Boolean> deleteLoanDetailById(Long loanId);
}
