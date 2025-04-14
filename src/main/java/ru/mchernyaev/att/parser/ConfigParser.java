package ru.mchernyaev.att.parser;

import ru.mchernyaev.att.models.Configuration;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

public interface ConfigParser {
    Configuration parse(String[] args) throws IOException;
}
