package ru.mchernyaev.att.models;

import java.nio.file.Path;
import java.util.List;

public record Configuration(
        Path configFilePath,
        int id,
        Mode mode,
        List<Path> paths,
        Action action
) {
}
