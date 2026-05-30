package ru.itis.musicform.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequest {
    private Long soundId;
    private String selectedNote;
    private Long sessionId;
}
