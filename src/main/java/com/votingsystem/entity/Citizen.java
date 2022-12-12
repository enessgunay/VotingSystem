package com.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "citizens")
public class Citizen {

    @Id
    @Column(name = "id")
    private int id;

    public Citizen() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "citizen_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Citizen(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Column(name = "hasvoted")
    private Boolean hasVoted;

    public Boolean getHasVoted() {
        return hasVoted;
    }

    public void setHasVoted(Boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}
