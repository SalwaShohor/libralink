package com.dareshuri.libralink.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dareshuri.libralink.Model.LoanDetail;

@Repository
public interface LoanDetailRepo extends CrudRepository<LoanDetail, Long>{
    
    // READ
    List<LoanDetail> findAllByUserId(Long userId);
    List<LoanDetail> findAllByBookId(Long bookId);
}
