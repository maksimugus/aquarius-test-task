package ru.mchernyaev.att.strategies;

import ru.mchernyaev.att.models.Mode;

import java.nio.file.Path;
import java.util.List;

public interface PathsSupplierFactory {
    PathsSupplier getStrategy(Mode mode, List<Path> paths);
}
