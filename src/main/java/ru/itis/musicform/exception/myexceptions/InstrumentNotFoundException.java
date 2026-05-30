package ru.itis.musicform.exception.myexceptions;

public class InstrumentNotFoundException extends RuntimeException {
    public InstrumentNotFoundException() {
        super("Instrument not found");
    }
}
