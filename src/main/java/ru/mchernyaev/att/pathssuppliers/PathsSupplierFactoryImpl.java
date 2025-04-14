package ru.mchernyaev.att.pathssuppliers;

import ru.mchernyaev.att.models.Mode;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathsSupplierFactoryImpl implements PathsSupplierFactory {
    private final Map<Mode, PathsSupplier> strategies;

    public PathsSupplierFactoryImpl() {
        strategies = new HashMap<>();
    }

    @Override
    public PathsSupplier getSupplier(Mode mode, List<Path> paths) {
        return strategies.computeIfAbsent(mode, m -> createStrategy(mode, paths));
    }

    private PathsSupplier createStrategy(Mode mode, List<Path> paths) {
        return switch (mode) {
            case DIR -> new DirectoryPathsSupplier(paths);
            case FILES -> new FilesListPathsSupplier(paths);
        };
    }
}
