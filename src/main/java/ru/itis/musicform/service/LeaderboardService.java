package ru.itis.musicform.service;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.musicform.api.dto.PlayerLeaderboardDTO;
import ru.itis.musicform.api.dto.TeamLeaderboardDTO;
import ru.itis.musicform.infrastructure.persistence.entity.UserEntity;
import ru.itis.musicform.infrastructure.persistence.repository.GameSessionRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaderboardService {
    private final GameSessionRepository sessionRepository;

    public List<PlayerLeaderboardDTO> getTopPlayers() {
        LocalDateTime weekStart = LocalDate.now().with(DayOfWeek.MONDAY).atStartOfDay();

        return sessionRepository.getTopPlayersWeek(weekStart, PageRequest.of(0,5));
    }

    public List<TeamLeaderboardDTO> getTopTeams() {
        LocalDateTime weekStart = LocalDate.now().with(DayOfWeek.MONDAY).atStartOfDay();

        return sessionRepository.getTopTeamsWeek(weekStart, PageRequest.of(0,5));
    }

    public Long getUserWeeklyScore(UserEntity user) {
        return sessionRepository.sumUserScore(user).orElse(0L);
    }
}
