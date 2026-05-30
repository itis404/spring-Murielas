package ru.itis.musicform.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SoundDetailsDTO {
    private Long id;
    private String name;
    private String username;
    private Previews previews;
}
