package ru.itis.musicform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.musicform.exception.myexceptions.UserAlreadyInTeamException;
import ru.itis.musicform.exception.myexceptions.UserNotFoundException;
import ru.itis.musicform.infrastructure.persistence.entity.MemberRole;
import ru.itis.musicform.infrastructure.persistence.entity.TeamEntity;
import ru.itis.musicform.infrastructure.persistence.entity.TeamMember;
import ru.itis.musicform.infrastructure.persistence.entity.UserEntity;
import ru.itis.musicform.infrastructure.persistence.repository.TeamMemberRepository;
import ru.itis.musicform.infrastructure.persistence.repository.TeamRepository;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMemberRepository memberRepository;

    public void createTeam(UserEntity user, String teamName) {
        if (memberRepository.findByUser(user).isPresent()) {
            throw new UserAlreadyInTeamException();
        }

        TeamEntity team = new TeamEntity();
        team.setTeamName(teamName);
        team = teamRepository.save(team);

        TeamMember member = new TeamMember();
        member.setUser(user);
        member.setTeam(team);
        member.setRole(MemberRole.LEADER);

        memberRepository.save(member);
    }

    public void joinTeam(UserEntity user, Long teamId) {
        if (memberRepository.findByUser(user).isPresent()) {
            throw new UserAlreadyInTeamException();
        }

        TeamEntity team = teamRepository.findById(teamId).orElseThrow();

        TeamMember member = new TeamMember();
        member.setUser(user);
        member.setTeam(team);
        member.setRole(MemberRole.MEMBER);

        memberRepository.save(member);
    }

    public void leaveTeam(UserEntity user) {
        TeamMember member = memberRepository.findByUser(user).orElseThrow(UserNotFoundException::new);
        memberRepository.delete(member);
    }
}
