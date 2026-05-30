package ru.itis.musicform.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.itis.musicform.exception.myexceptions.*;

@Slf4j
@ControllerAdvice
public class HtmlExceptionHandler {
    @ExceptionHandler(SoundNotFoundException.class)
    public String handleNotFound(SoundNotFoundException ex, Model model) {
        log.error("Sound not found", ex);
        model.addAttribute("message",
                ex.getMessage());

        return "error/404";
    }

    @ExceptionHandler(GamemodeNotFoundException.class)
    public String handleNotFound(GamemodeNotFoundException ex, Model model) {
        log.error("Gamemode not found", ex);
        model.addAttribute("message",
                ex.getMessage());

        return "error/404";
    }

    @ExceptionHandler(GameSessionNotFoundException.class)
    public String handleNotFound(GameSessionNotFoundException ex, Model model) {
        log.error("Game session not found", ex);
        model.addAttribute("message",
                ex.getMessage());

        return "error/404";
    }

    @ExceptionHandler(InstrumentNotFoundException.class)
    public String handleNotFound(InstrumentNotFoundException ex, Model model) {
        log.error("Instrument not found", ex);
        model.addAttribute("message",
                ex.getMessage());

        return "error/404";
    }

    @ExceptionHandler(SoundsNotFoundException.class)
    public String handleNotFound(SoundsNotFoundException ex, Model model) {
        log.error("Sounds not found for this instrument", ex);
        model.addAttribute("message",
                ex.getMessage());

        return "error/404";
    }

    @ExceptionHandler(TeamNotFoundException.class)
    public String handleNotFound(TeamNotFoundException ex, Model model) {
        log.error("Team not found", ex);
        model.addAttribute("message",
                ex.getMessage());

        return "error/404";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String handleNotFound(UserNotFoundException ex, Model model) {
        log.error("User not found", ex);
        model.addAttribute("message",
                ex.getMessage());

        return "error/404";
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public String handleBadRequest(Exception ex, Model model) {
        log.error("Illegal argument", ex);
        model.addAttribute("message",
                ex.getMessage());

        return "error/400";
    }

    @ExceptionHandler(Exception.class)
    public String handleServerError(Exception ex, Model model, HttpServletRequest request) {
        log.error("Unexpected error", ex);
        model.addAttribute("message",
                "Something went wrong");

        model.addAttribute("path",
                request.getRequestURI());

        return "error/500";
    }

}
