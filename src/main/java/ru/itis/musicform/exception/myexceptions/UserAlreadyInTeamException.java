package ru.itis.musicform.exception.myexceptions;

public class UserAlreadyInTeamException extends RuntimeException {
    public UserAlreadyInTeamException() {
        super("User already in team");
    }
}

