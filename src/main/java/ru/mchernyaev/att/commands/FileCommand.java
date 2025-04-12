package ru.mchernyaev.att.commands;

import java.nio.file.Path;
import java.util.List;

public interface FileCommand {
    void execute(List<Path> files);
}
