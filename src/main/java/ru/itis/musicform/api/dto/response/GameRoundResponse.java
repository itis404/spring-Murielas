package ru.itis.musicform.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameRoundResponse {
    private Long soundId;
    private String noteName;
    private String previewURL;
}
