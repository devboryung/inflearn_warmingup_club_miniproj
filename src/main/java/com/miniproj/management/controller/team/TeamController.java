package com.miniproj.management.controller.team;

import com.miniproj.management.dto.team.request.TeamSaveRequest;
import com.miniproj.management.dto.team.response.TeamResponse;
import com.miniproj.management.service.team.TeamService;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    //팀 등록
    @PostMapping("/team/save")
    public void saveTeam(@RequestBody TeamSaveRequest request) {
        teamService.saveTeam(request);
    }

    //팀 조회
    @GetMapping("/team")
    public List<TeamResponse> getTeams() {
        return teamService.getTeams();
    }
}
