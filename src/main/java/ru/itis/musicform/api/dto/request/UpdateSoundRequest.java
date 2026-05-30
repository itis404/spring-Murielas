package ru.itis.musicform.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSoundRequest {
    @NotBlank(message = "Введите актуальное название звука")
    private String soundName;

    @NotBlank(message = "Выберите актуальную ноту этого звука")
    private String noteName;

    private String audioUrl;
}
