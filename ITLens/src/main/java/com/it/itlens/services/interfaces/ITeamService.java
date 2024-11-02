package com.it.itlens.services.interfaces;

import com.it.itlens.models.entities.Team;

public interface ITeamService {
    Team createTeam(Team team);
    Team getTeamById(Long id);
}
