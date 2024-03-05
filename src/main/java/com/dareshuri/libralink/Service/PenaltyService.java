package com.dareshuri.libralink.Service;

import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.dareshuri.libralink.Model.Penalty;

@Service()
public interface PenaltyService {

    //CREATE
    Penalty addPenalty(Penalty penalty);

    //READ
    Iterable<Penalty> getAllPenalty();
    Optional<Penalty> getPenaltyByLoanId(Long id);
    Optional<Penalty> getPenaltyById(Long id);

    //UPDATE
    Penalty updateAmountById(Long id, Long amount);
    Penalty updatePaymentStatusById(Long id, Map<String, String> penaltyMap);

    //DELETE
    String deletePenaltyById(Long id);
    String deletePenaltyByLoanId(Long loanId);
}