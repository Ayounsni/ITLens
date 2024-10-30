package com.it.itlens.controllers;


import com.it.itlens.models.Team;
import com.it.itlens.repository.TeamRepository;
import com.it.itlens.services.implementation.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TeamController {

    @Autowired
    private TeamService teamService;
    @PostMapping
    public ResponseEntity<Team> createTeam(@Valid @RequestBody Team team) {
            Team te = teamService.createTeam(team);
            return new ResponseEntity<>(te, HttpStatus.OK);

    }
}
