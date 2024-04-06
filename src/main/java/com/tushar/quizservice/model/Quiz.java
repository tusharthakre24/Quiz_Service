package com.tushar.quizservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Quiz {

    @Id
    private Integer id;
    private String category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
