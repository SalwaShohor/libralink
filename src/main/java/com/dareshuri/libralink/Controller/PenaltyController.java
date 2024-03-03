package com.dareshuri.libralink.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dareshuri.libralink.Model.Penalty;
import com.dareshuri.libralink.Service.PenaltyService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/penalty")
public class PenaltyController {

    @Autowired
    PenaltyService penaltyService;

    //CREATE
    @PostMapping("/add")
    public Penalty addPenalty(@RequestBody Penalty penalty) {
        return penaltyService.addPenalty(penalty);
    }

    //READ
    @GetMapping("/get-by-loan-id/{id}")
    Optional<Penalty> getPenaltyByLoanId(@PathVariable Long id){
        return penaltyService.getPenaltyByLoanId(id);
    }

    @GetMapping("/get-all")
    Iterable<Penalty> getAllPenalty(){
        return penaltyService.getAllPenalty();
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<Penalty> getPenaltyById(@PathVariable Long id) {
        return penaltyService.getPenaltyById(id);
    }

    //UPDATE
    @PutMapping("/update-amount-by-id/{id}")
    public Penalty updateAmountById(@PathVariable Long id, @RequestParam Long amount) {
        return penaltyService.updateAmountById(id, amount);
    }

    @PutMapping("/update-payment-status-by-id/{id}")
    public Penalty updatePaymentStatus(@PathVariable Long id, @RequestParam Boolean status) {
        return penaltyService.updatePaymentStatusById(id, status);
    }

    //DELETE
    @DeleteMapping("delete-by-id/{id}")
    public String deletePenaltyById(@PathVariable Long id){
        return penaltyService.deletePenaltyById(id);
    }

    @DeleteMapping("delete-by-loan-id/{loanId}")
    public String deletePenaltyByLoanId(@PathVariable Long loanId){
        return penaltyService.deletePenaltyByLoanId(loanId);
    }
    
}