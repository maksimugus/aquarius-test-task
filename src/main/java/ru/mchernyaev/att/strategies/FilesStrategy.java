package ru.mchernyaev.att.strategies;

import java.nio.file.Path;
import java.util.List;

public class FilesStrategy implements Strategy {
    @Override
    public List<Path> getFiles() {
        return List.of();
    }
}
