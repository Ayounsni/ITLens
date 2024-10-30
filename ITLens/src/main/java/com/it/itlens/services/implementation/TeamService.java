package com.it.itlens.services.implementation;

import com.it.itlens.repository.TeamRepository;
import com.it.itlens.models.Team;
import com.it.itlens.services.interfaces.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService implements ITeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }
}
