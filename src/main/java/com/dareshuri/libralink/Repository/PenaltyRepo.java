package com.dareshuri.libralink.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dareshuri.libralink.Model.Penalty;

@Repository
public interface PenaltyRepo extends CrudRepository<Penalty,Long> {
    Optional<Penalty> findById(Long id);
    Optional<Penalty> findByLoanId(Long loanId);
}
