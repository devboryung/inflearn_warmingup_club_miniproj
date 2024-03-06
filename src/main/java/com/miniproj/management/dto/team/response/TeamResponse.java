package com.miniproj.management.dto.team.response;

import com.miniproj.management.domain.team.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TeamResponse {

    private String name;
    private String manager;
    private int memberCount;

    public TeamResponse(Team team) {
        this.name = team.getName();
        this.manager = team.getManager();
        this.memberCount = team.getNumberOfEmp();
    }
}
