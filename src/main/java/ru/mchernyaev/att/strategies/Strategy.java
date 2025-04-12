package ru.mchernyaev.att.strategies;

import java.nio.file.Path;
import java.util.List;

public interface Strategy {
    List<Path> getFiles();
}
