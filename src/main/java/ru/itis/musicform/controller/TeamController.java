package ru.itis.musicform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.musicform.infrastructure.persistence.entity.UserEntity;
import ru.itis.musicform.infrastructure.persistence.repository.TeamMemberRepository;
import ru.itis.musicform.infrastructure.persistence.repository.TeamRepository;
import ru.itis.musicform.service.TeamService;
import ru.itis.musicform.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teams")
public class TeamController {
    private final TeamRepository teamRepository;
    private final TeamService teamService;
    private final UserService userService;
    private final TeamMemberRepository memberRepository;

    @GetMapping
    public String listTeams(Model model) {
        UserEntity user = userService.getActiveUser();

        model.addAttribute("userTeam", memberRepository.findByUser(user).orElse(null));
        model.addAttribute("teams", teamRepository.findAll());
        model.addAttribute("user", user);

        return "teams";
    }

    @PostMapping("/create")
    public String createTeam(@RequestParam String teamName) {
        if (teamName == null || teamName.isBlank()) {
            throw new IllegalArgumentException("Название пустое");
        }

        teamService.createTeam(userService.getActiveUser(), teamName);

        return "redirect:/teams";
    }

    @PostMapping("/join")
    public String joinTeam(@RequestParam Long id) {
        teamService.joinTeam(userService.getActiveUser(), id);

        return "redirect:/teams";
    }

    @PostMapping("/leave")
    public String leaveTeam() {
        teamService.leaveTeam(userService.getActiveUser());

        return "redirect:/teams";
    }
}
