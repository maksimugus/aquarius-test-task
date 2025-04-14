package ru.mchernyaev.att.strategies;

import java.nio.file.Path;
import java.util.List;

public abstract class AbstractPathsSupplier implements PathsSupplier {
    protected final List<Path> paths;

    public AbstractPathsSupplier(List<Path> paths) {
        this.paths = paths;
    }
}
