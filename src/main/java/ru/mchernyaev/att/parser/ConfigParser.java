package ru.mchernyaev.att.parser;

import ru.mchernyaev.att.models.Configuration;

import java.nio.file.NoSuchFileException;

public interface ConfigParser {
    Configuration parse(String[] args) throws NoSuchFileException;
}
