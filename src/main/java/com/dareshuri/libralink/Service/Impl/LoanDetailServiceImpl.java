package com.dareshuri.libralink.Service.Impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.LoanDetail;
import com.dareshuri.libralink.Repository.LoanDetailRepo;
import com.dareshuri.libralink.Service.LoanDetailService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoanDetailServiceImpl implements LoanDetailService {

    @Autowired
    LoanDetailRepo loanDetailRepo;

    // CREATE
    @Override
    public LoanDetail addLoanDetail(LoanDetail loanDetail) {
        return loanDetailRepo.save(loanDetail);
    }

    // READ
    @Override
    public Iterable<LoanDetail> getAllLoanDetails() {
        return loanDetailRepo.findAll();
    }

    @Override
    public Optional<LoanDetail> getLoanDetailById(Long loanId) {
        return loanDetailRepo.findById(loanId);
    }

    @Override
    public List<LoanDetail> getLoanDetailByUserId(Long userId) {
        return loanDetailRepo.findAllByUserId(userId);
    }

    @Override
    public List<LoanDetail> getLoanDetailByBookId(Long bookId) {
        return loanDetailRepo.findAllByBookId(bookId);
    }

    @Override
    public List<LoanDetail> getLoanDetailByLoanDate(String loanDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date formattedLoanDate = formatter.parse(loanDate);

        Date loanDatePlusOne = new Date(formattedLoanDate.getTime() + (1000 * 60 * 60 * 24));
        return loanDetailRepo.findByLoanDate(loanDatePlusOne);
    }

    @Override
	public List<LoanDetail> getLoanDetailByDueDate(String dueDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date formattedDueDate = formatter.parse(dueDate);

        Date dueDatePlusOne = new Date(formattedDueDate.getTime() + (1000 * 60 * 60 * 24));
        return loanDetailRepo.findByDueDate(dueDatePlusOne);	
    }

	@Override
	public List<LoanDetail> getLoanDetailByReturnDate(String returnDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date formattedReturnDate = formatter.parse(returnDate);

        Date returnDatePlusOne = new Date(formattedReturnDate.getTime() + (1000 * 60 * 60 * 24));
        return loanDetailRepo.findByReturnDate(returnDatePlusOne);
    }
    
    

    // UPDATE
    @Override
    public LoanDetail updateLoanDetailById(Long loanId, Map<String, String> loanDetailMap) throws ParseException {
        Optional<LoanDetail> loanDetailToUpdateOptional = loanDetailRepo.findById(loanId);

        if (loanDetailToUpdateOptional.isPresent()) {
            LoanDetail loanDetailToUpdate = loanDetailToUpdateOptional.get();
            loanDetailToUpdate.setBookId(Long.parseLong(loanDetailMap.get("bookId")));

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date formattedLoanDate = formatter.parse(loanDetailMap.get("loanDate"));
            loanDetailToUpdate.setLoanDate(new Date(formattedLoanDate.getTime() + (1000 * 60 * 60 * 24)));

            Date formattedDueDate = formatter.parse(loanDetailMap.get("dueDate"));
            loanDetailToUpdate.setDueDate(new Date(formattedDueDate.getTime() + (1000 * 60 * 60 * 24)));

            Date formattedReturnDate = formatter.parse(loanDetailMap.get("returnDate"));
            loanDetailToUpdate.setReturnDate(new Date(formattedReturnDate.getTime() + (1000 * 60 * 60 * 24)));

            loanDetailToUpdate.setStatus(loanDetailMap.get("status"));
            return loanDetailRepo.save(loanDetailToUpdate);
        }
        return null;
    }

    // DELETE
    @Override
    public String deleteLoanDetailById(Long loanId) {
        Optional<LoanDetail> loanDetailToDeleteOptional = loanDetailRepo.findById(loanId);

        if (loanDetailToDeleteOptional.isPresent()) {
            LoanDetail loanDetailToDelete = loanDetailToDeleteOptional.get();
            loanDetailRepo.delete(loanDetailToDelete);
            return String.format("Loan Detail with id %d successfully deleted!", loanId);
        }

        return String.format("Loan Detail with id %d not found!", loanId);
    }

	

}
