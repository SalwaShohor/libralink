package com.dareshuri.libralink.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;
    @NotBlank
    private String name;

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    
}
