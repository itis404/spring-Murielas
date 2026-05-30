package ru.itis.musicform.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateInstrumentRequest {
    @NotBlank(message = "Название инструмента обязательно")
    private String name;

    private String description;
}
