package ru.mchernyaev.att.exceptions;

public class InvalidArgumentsNumberException extends RuntimeException {
    public InvalidArgumentsNumberException(int expectedArgsNumber, int actualArgsNumber) {
        super("Expected %d arguments, but %d was received"
                .formatted(expectedArgsNumber, actualArgsNumber));
    }
}
