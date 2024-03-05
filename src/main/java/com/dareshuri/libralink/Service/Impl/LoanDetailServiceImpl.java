package com.dareshuri.libralink.Service.Impl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
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
        loanDetail.setLoanDate(LocalDate.now());
        loanDetail.setDueDate(loanDetail.getLoanDate().plusDays(12));
        loanDetail.setStatus("PENDING");
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

    // UPDATE
    @Override
    public LoanDetail updateReturnDateById(Long loanId, Map<String, String> loanDetailMap) throws ParseException {
        Optional<LoanDetail> loanDetailToUpdateOptional = loanDetailRepo.findById(loanId);

        if (loanDetailToUpdateOptional.isPresent()) {
            LoanDetail loanDetailToUpdate = loanDetailToUpdateOptional.get();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            loanDetailToUpdate.setReturnDate(LocalDate.parse(loanDetailMap.get("returnDate"), formatter));
            return loanDetailRepo.save(loanDetailToUpdate);
        }
        return null;
    }

    @Override
    public LoanDetail updateStatusById(Long loanId, Map<String, String> loanDetailMap) {
        Optional<LoanDetail> loanDetailToUpdateOptional = loanDetailRepo.findById(loanId);

        if (loanDetailToUpdateOptional.isPresent()) {
            LoanDetail loanDetailToUpdate = loanDetailToUpdateOptional.get();
            loanDetailToUpdate.setStatus(loanDetailMap.get("status"));
            return loanDetailRepo.save(loanDetailToUpdate);
        }
        return null;
    }

    // DELETE
    @Override
    public Map<String,Boolean> deleteLoanDetailById(Long loanId) {
        Map<String,Boolean> resMap = new HashMap<>();
        Optional<LoanDetail> loanDetailToDeleteOptional = loanDetailRepo.findById(loanId);

        if (loanDetailToDeleteOptional.isPresent()) {
            LoanDetail loanDetailToDelete = loanDetailToDeleteOptional.get();
            loanDetailRepo.delete(loanDetailToDelete);
            resMap.put("deleteStatus", true);
            return resMap;
        } else{
            resMap.put("deleteStatus", false);
            return resMap;
        }
    }
}
