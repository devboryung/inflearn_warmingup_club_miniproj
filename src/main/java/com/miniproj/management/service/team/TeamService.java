package com.miniproj.management.service.team;

import com.miniproj.management.domain.team.Team;
import com.miniproj.management.domain.team.TeamRepository;
import com.miniproj.management.dto.team.request.TeamSaveRequest;
import com.miniproj.management.dto.team.response.TeamResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveTeam(TeamSaveRequest request) {
        teamRepository.save(new Team(request.getName()));
    }

    @Transactional(readOnly = true)
    public List<TeamResponse> getTeams() {
        List<Team> teams = teamRepository.findAll();
        List<TeamResponse> teamResponseList = teams.stream().map(team -> new TeamResponse(team)).collect(Collectors.toList());

       return teamResponseList;
    }
}
