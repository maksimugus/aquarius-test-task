package ru.mchernyaev.att.pathssuppliers;

import ru.mchernyaev.att.models.Mode;

import java.nio.file.Path;
import java.util.List;

public interface PathsSupplierFactory {
    PathsSupplier getSupplier(Mode mode, List<Path> paths);
}
