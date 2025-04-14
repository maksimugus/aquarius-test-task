package ru.mchernyaev.att.exceptions;

public class InvalidConfigException extends RuntimeException {

    public InvalidConfigException(String configPath, Throwable cause) {
        super("Config %s is invalid".formatted(configPath), cause);
    }

    public InvalidConfigException(String configPath) {
        this(configPath, null);
    }
}
