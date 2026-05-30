package ru.itis.musicform.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInstrumentRequest {
    @NotBlank(message = "Напишите название инструмента")
    private String name;

    @Size(max = 200)
    private String description;
}
