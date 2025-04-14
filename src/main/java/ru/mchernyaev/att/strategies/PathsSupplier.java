package ru.mchernyaev.att.strategies;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface PathsSupplier {
    List<Path> getPaths() throws IOException;
}
