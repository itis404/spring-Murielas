package ru.itis.musicform.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSoundRequest {
    @NotBlank(message = "Выберите ноту")
    private String noteName;

    @NotBlank(message = "Выберите звук из представленных")
    private String freesoundId;

    @NotNull(message = "Выберите инструмент")
    private Long instrumentId;

    private String audioUrl;
    private String soundName;
}
