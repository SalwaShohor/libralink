package com.dareshuri.libralink.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Model.LoanDetail;
import com.dareshuri.libralink.Service.LoanDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/loan-detail")
public class LoanDetailController {

    @Autowired
    LoanDetailService loanDetailService;

    // CREATE
    @PostMapping("/add")
    public LoanDetail loanDetail(@RequestBody LoanDetail loanDetail) {
        return loanDetailService.addLoanDetail(loanDetail);
    }

    // READ
    @GetMapping("/get-all")
    public Iterable<LoanDetail> getAllLoanDetails() {
        return loanDetailService.getAllLoanDetails();
    }

    @GetMapping("/get-by-id/{loanDetailId}")
    public Optional<LoanDetail> getLoanDetailById(@PathVariable Long loanDetailId) {
        return loanDetailService.getLoanDetailById(loanDetailId);
    }

    @GetMapping("/get-all-by-user-id/{userId}")
    public List<LoanDetail> getLoanDetailByUserId(@PathVariable Long userId) {
        return loanDetailService.getLoanDetailByUserId(userId);
    }

    // UPDATE
    @PutMapping("/update-return-date-by-id/{loanId}")
    public LoanDetail updateReturnDateById(@PathVariable Long loanId, @RequestBody Map<String, String> loanDetailMap)
            throws ParseException {
        return loanDetailService.updateReturnDateById(loanId, loanDetailMap);
    }

    @PutMapping("/update-status-by-id/{loanId}")
    public LoanDetail updateStatusById(@PathVariable Long loanId, @RequestBody Map<String, String> loanDetailMap) {
        return loanDetailService.updateStatusById(loanId, loanDetailMap);
    }

    // DELETE
    @DeleteMapping("/delete-by-id/{loanId}")
    public Map<String,Boolean> deleteLoanDetailById(@PathVariable Long loanId) {
        return loanDetailService.deleteLoanDetailById(loanId);
    }

}
