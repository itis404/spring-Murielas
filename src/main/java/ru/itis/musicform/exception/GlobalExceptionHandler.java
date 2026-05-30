package ru.itis.musicform.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.itis.musicform.api.dto.response.ErrorResponse;
import ru.itis.musicform.exception.myexceptions.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SoundNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSoundNotFound (SoundNotFoundException exception) {
        log.error("Sound not found", exception);
        ErrorResponse response = new ErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(GamemodeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleGamemodeNotFound (GamemodeNotFoundException exception) {
        log.error("Gamemode not found", exception);
        ErrorResponse response = new ErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(GameSessionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleGameSessionNotFound (GameSessionNotFoundException exception) {
        log.error("Game session not found", exception);
        ErrorResponse response = new ErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InstrumentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleInstrumentNotFound (InstrumentNotFoundException exception) {
        log.error("Instrument not found", exception);
        ErrorResponse response = new ErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(SoundsNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSoundsNotFound (SoundsNotFoundException exception) {
        log.error("Sounds not found", exception);
        ErrorResponse response = new ErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTeamNotFound (TeamNotFoundException exception) {
        log.error("Team not found", exception);
        ErrorResponse response = new ErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound (UserNotFoundException exception) {
        log.error("User not found", exception);
        ErrorResponse response = new ErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyExists (UserAlreadyExistsException exception) {
        log.warn(exception.getMessage());
        ErrorResponse response = new ErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(UserAlreadyInTeamException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyInTeam (UserAlreadyInTeamException exception) {
        log.warn(exception.getMessage());
        ErrorResponse response = new ErrorResponse(exception.getMessage(), 404);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(errors);
    }
}
