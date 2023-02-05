package com.exam.models.exam;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="catagory")
public class Catagory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;
    private String title;

    private String description;

    @OneToMany(mappedBy = "catagory",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Quiz> quizSet = new LinkedHashSet<>();



    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catagory() {
    }

    public Catagory(String title, String description) {
        this.title = title;
        this.description = description;
    }



}
