package com.dareshuri.libralink.Service;

import java.text.ParseException;
import java.util.Date;
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
    List<LoanDetail> getLoanDetailByBookId(Long bookId);
    List<LoanDetail> getLoanDetailByLoanDate(String loanDate) throws ParseException;
    // List<LoanDetail> getLoanDetailByDueDate(String dueDate) throws ParseException;
    // List<LoanDetail> getLoanDetailByReturnDate(String returnDate) throws ParseException;

    // UPDATE
    LoanDetail updateBookIdById(Long loanId, Map<String, String> loanDetailMap);
    LoanDetail updateLoanDateById(Long loanId, Map<String, String> loanDetailMap) throws ParseException;
    LoanDetail updateDueDateById(Long loanId, Map<String, String> loanDetailMap) throws ParseException;
    LoanDetail updateReturnDateById(Long loanId, Map<String, String> loanDetailMap) throws ParseException;
    LoanDetail updateStatusById(Long loanId, Map<String, String> loanDetailMap);
    
    // DELETE
    String deleteLoanDetailById(Long loanId);
}
