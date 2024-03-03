package com.dareshuri.libralink.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dareshuri.libralink.Model.Penalty;
import com.dareshuri.libralink.Service.PenaltyService;

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
    @GetMapping("/get-by-loanid/{id}")
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

    //DELETE
    @DeleteMapping("delete-by-id/{id}")
    public String deleteUserById(@PathVariable Long id){
        return penaltyService.deletePenaltyById(id);
    }

    @DeleteMapping("delete-by-loanid/{loanId}")
    public String deleteUserByLoanId(@PathVariable Long loanId){
        return penaltyService.deletePenaltyById(loanId);
    }
    
}