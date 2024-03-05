package com.dareshuri.libralink.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dareshuri.libralink.Model.Publisher;
import com.dareshuri.libralink.Service.PublisherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    //CREATE
    @PostMapping("/add-publisher")
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherService.addPublisher(publisher);
    }

    @PostMapping("/add-multiple-publisher")
    public Iterable<Publisher> addPublisher(@RequestBody List<Publisher> publisherList) {
        return publisherService.addMultiPublisher(publisherList);
    }
    
    //READ
    @GetMapping("/get-all")
    Iterable<Publisher> getAllPublisher(){
        return publisherService.getAllPublisher();
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<Publisher> getPublisherById(@PathVariable Long id) {
        return publisherService.getPublisherById(id);
    }

    //UPDATE
    @PutMapping("/update-publisher-info-by-id/{id}")
    public Publisher updatePublisherInfoById(@PathVariable Long id, @RequestBody Map<String,String> inpMap) {
        return publisherService.updatePublisherInfoById(id, inpMap);
    }

    //DELETE
    @DeleteMapping("/delete-by-id/{id}")
    public String deletePublisherById(@PathVariable Long id){
        return publisherService.deletePublisherById(id);
    }


    
}