package ru.mchernyaev.att.commands;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileCommand {
    List<List<String>> execute(List<Path> files) throws IOException;
}
