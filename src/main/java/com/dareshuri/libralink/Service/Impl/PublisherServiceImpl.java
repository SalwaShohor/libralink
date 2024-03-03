package com.dareshuri.libralink.Service.Impl;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dareshuri.libralink.Model.Publisher;
import com.dareshuri.libralink.Repository.PublisherRepo;
import com.dareshuri.libralink.Service.PublisherService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService{

    @Autowired 
    PublisherRepo publisherRepo;

    //CREATE
    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    @Override
    public Iterable<Publisher> addMultiPublisher(List<Publisher> publisherList) {
        return publisherRepo.saveAll(publisherList);
    }

    //READ
    @Override
    public Iterable<Publisher> getAllPublisher() {
        return publisherRepo.findAll();
    }

    @Override
    public Optional<Publisher> getPublisherById(Long id) {
        return publisherRepo.findById(id);
    }

    //UPDATE
    @Override
    public Publisher updatePublisherInfoById(Long id, Map<String, String> inpMap) {
        Optional<Publisher> publisherOptional = publisherRepo.findById(id);
        
        if(publisherOptional.isPresent()){
            Publisher publisher = publisherOptional.get();
            publisher.setAddress(inpMap.get("address"));
            publisher.setPhoneNumber(inpMap.get("phoneNumber"));
            return publisherRepo.save(publisher);
        }

        return null;
    }
    
    //DELETE
    @Override
    public String deletePublisherById(Long id){
        Optional<Publisher> publisherToDeleteOptional = publisherRepo.findById(id);

        if(publisherToDeleteOptional.isPresent()){
            Publisher publisherToDelete = publisherToDeleteOptional.get();
            publisherRepo.delete(publisherToDelete);
            return String.format("Publisher with %d id is successfully deleted!", publisherToDelete.getPublisherId());
        }
        return String.format("Publisher not found!");
    }
    
}