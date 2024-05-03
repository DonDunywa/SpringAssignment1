package com.example.springassignment1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Valid
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50)
    private String name;
    @NotNull
    @NotBlank(message = "Description is required")
    @Size(min = 2, max = 50)
    private String description;
    @NotNull
    @NotBlank(message = "Category is required")
    @Size(min = 2, max = 50)
    private String category; // Added category attribute

    //Getters And Setters For ID
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    //Getters And Setters For Name
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    //Getters and Setters for Description
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    //Getters and Setters For Category
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return category;
    }
}
