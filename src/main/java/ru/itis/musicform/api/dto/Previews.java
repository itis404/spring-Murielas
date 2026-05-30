package ru.itis.musicform.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Previews {
    @JsonProperty("preview-hq-mp3")
    private String previewMp3;
}
