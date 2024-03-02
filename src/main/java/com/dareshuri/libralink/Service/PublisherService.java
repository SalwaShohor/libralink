package com.dareshuri.libralink.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Publisher;

@Service()
public interface PublisherService {
    
    //CREATE
    Publisher addPublisher(Publisher publisher);
    Iterable<Publisher> addMultiPublisher(List<Publisher> publisherList);

    //READ
    Iterable<Publisher> getAllPublisher();
    Optional<Publisher> getPublisherById(Long id);

    //UPDATE
    Publisher updatePublisherInfoById(Long id, Map<String,String> inpMap);

    //DELETE
    String deletePublisherById(Long id);
    
}