package com.votingsystem.repositories;

import com.votingsystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
    public Candidate findById(int id);
}
