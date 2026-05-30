package ru.itis.musicform.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlayerLeaderboardDTO {
    private String username;
    private Long totalScore;
}
