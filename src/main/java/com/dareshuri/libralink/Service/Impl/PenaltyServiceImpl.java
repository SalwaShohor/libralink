package com.dareshuri.libralink.Service.Impl;

import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dareshuri.libralink.Model.Penalty;
import com.dareshuri.libralink.Repository.PenaltyRepo;
import com.dareshuri.libralink.Service.PenaltyService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PenaltyServiceImpl implements PenaltyService{

    @Autowired
    PenaltyRepo penaltyRepo;

    //CREATE
    @Override
    public Penalty addPenalty(Penalty penalty) {
        return penaltyRepo.save(penalty);
    }

    //READ
    @Override
    public Iterable<Penalty> getAllPenalty() {
        return penaltyRepo.findAll();
    }

    @Override
    public Optional<Penalty> getPenaltyByLoanId(Long loanId) {
        return penaltyRepo.findByLoanId(loanId);
    }

    @Override
    public Optional<Penalty> getPenaltyById(Long penaltyId) {
        return penaltyRepo.findById(penaltyId);
    }

    // UPDATE
    @Override
    public Penalty updateAmountById(Long id, Long amount) {
        Optional<Penalty> penaltyOptional = penaltyRepo.findById(id);
        
        if(penaltyOptional.isPresent()){
            Penalty penalty = penaltyOptional.get();
            penalty.setAmount(amount);
            return penaltyRepo.save(penalty);
        }

        return null;
    }

    @Override
    public Penalty updatePaymentStatusById(Long id, Map<String, String> penaltyMap) {
        Optional<Penalty> penaltyOptional = penaltyRepo.findById(id);
        
        if(penaltyOptional.isPresent()){
            Penalty penalty = penaltyOptional.get();
            penalty.setPaymentStatus(Boolean.parseBoolean(penaltyMap.get("paymentStatus")));
            return penaltyRepo.save(penalty);
        }

        return null;
    }


    //DELETE
    @Override
    public String deletePenaltyById(Long id) {
        Optional<Penalty> penaltyOptional = penaltyRepo.findById(id);
        
        if(penaltyOptional.isPresent()){
            Penalty penalty = penaltyOptional.get();
            penaltyRepo.delete(penalty);
            return String.format("Penalty with id %d successfully deleted!", id);
        }

        return String.format("Penalty with id %d not found!", id);
    }

    @Override
    public String deletePenaltyByLoanId(Long loanId) {
        Optional<Penalty> penaltyOptional = penaltyRepo.findByLoanId(loanId);
        
        if(penaltyOptional.isPresent()){
            Penalty penalty = penaltyOptional.get();
            penaltyRepo.delete(penalty);
            return String.format("Penalty with loan id %d successfully deleted!", loanId);
        }

        return String.format("Penalty with loan id %d not found!", loanId);
    }
}