package ru.itis.musicform.exception.myexceptions;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException() {
        super("Team not found");
    }
}
