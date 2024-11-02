package com.it.itlens.services.implementation;

import com.it.itlens.repository.TeamRepository;
import com.it.itlens.models.entities.Team;
import com.it.itlens.services.interfaces.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team getTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Le team avec l'ID " + id + " n'existe pas."));;
        return team;
    }
}
