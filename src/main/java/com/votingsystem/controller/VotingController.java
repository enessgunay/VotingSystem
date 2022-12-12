package com.votingsystem.controller;

import com.votingsystem.entity.Candidate;
import com.votingsystem.entity.Citizen;
import com.votingsystem.repositories.CandidateRepo;
import com.votingsystem.repositories.CitizenRepo;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;



@Controller
public class VotingController {

    public final Logger logger = Logger.getLogger(VotingController.class);

    @Autowired
    CitizenRepo citizenRepo;

    @Autowired
    CandidateRepo candidateRepo;

    @RequestMapping("/")
    public String goToVote(){
        logger.info("Returning vote.html file");
        return "vote.html";
    }

    @RequestMapping("/doLogin")
    public String doLogin(@RequestParam String name, Model model, HttpSession session){

        logger.info("Getting citizen from database");
        Citizen citizen = citizenRepo.findByName(name);

        logger.info("Putting citizen into session");
        session.setAttribute("citizen", citizen);

        if (!citizen.getHasVoted()){
            logger.info("Putting candidates into model");
            List<Candidate> candidates = candidateRepo.findAll();
            model.addAttribute("candidates",   candidates);

            return "/performVoted.html";
        } else {
            return "/alreadyVoted.html";
        }
    }

    @RequestMapping("/voteFor")
    public String voteFor(@RequestParam Integer id, HttpSession session){

        Citizen citizen = (Citizen) session.getAttribute("citizen");

        if (!citizen.getHasVoted()){
            citizen.setHasVoted(true);
            Candidate c = candidateRepo.findById((int) id);
            logger.info("Voting for candidate " + c.getName());
            c.setNumberOfVotes(c.getNumberOfVotes() + 1);
            candidateRepo.save(c);
            citizenRepo.save(citizen);
            return "voted.html";
        }

        return "alreadyVoted.html";


    }



}
