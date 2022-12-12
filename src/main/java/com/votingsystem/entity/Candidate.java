package com.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @Column(name = "id")
    private int id;

    public Candidate() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "candidate_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Candidate(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Column(name = "numberOfVotes")
    private Integer numberOfVotes;

    public Integer getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(Integer numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }

    public Candidate(int id, String name, Integer numberOfVotes) {
        this.id = id;
        this.name = name;
        this.numberOfVotes = numberOfVotes;
    }
}
