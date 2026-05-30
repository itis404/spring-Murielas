package ru.itis.musicform.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.musicform.infrastructure.persistence.entity.UserEntity;
import ru.itis.musicform.service.LeaderboardService;
import ru.itis.musicform.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/leaderboard")
public class LeaderboardController {
    private final LeaderboardService leaderboardService;
    private final UserService userService;

    @GetMapping
    public String leaderboardPage(Model model) {
        UserEntity user = userService.getActiveUser();

        model.addAttribute("topPlayers", leaderboardService.getTopPlayers());
        model.addAttribute("topTeams", leaderboardService.getTopTeams());
        model.addAttribute("myScore", leaderboardService.getUserWeeklyScore(user));

        return "leaderboard";
    }
}
