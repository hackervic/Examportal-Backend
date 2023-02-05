package com.exam.models.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qID;
    private String title;
    private String description;
    private String maxMarks;
    private String numOfQuestion;
    private boolean isActive = false;

    @ManyToOne(fetch = FetchType.EAGER)
    private Catagory catagory;

    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }

    @OneToMany(mappedBy = "quiz", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Question> questions = new LinkedHashSet<>();

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Quiz() {
    }


    public Quiz(Long qID, String title, String description, String maxMarks, String numOfQuestion, boolean isActive, Catagory catagory) {
        this.qID = qID;
        this.title = title;
        this.description = description;
        this.maxMarks = maxMarks;
        this.numOfQuestion = numOfQuestion;
        this.isActive = isActive;
        this.catagory = catagory;
    }

    public Long getqID() {
        return qID;
    }

    public void setqID(Long qID) {
        this.qID = qID;
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

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getNumOfQuestion() {
        return numOfQuestion;
    }

    public void setNumOfQuestion(String numOfQuestion) {
        this.numOfQuestion = numOfQuestion;
    }


}
