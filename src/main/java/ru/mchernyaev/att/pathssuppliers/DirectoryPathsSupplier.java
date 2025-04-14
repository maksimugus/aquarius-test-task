package ru.mchernyaev.att.pathssuppliers;

import ru.mchernyaev.att.exceptions.InvalidConfigException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DirectoryPathsSupplier extends AbstractPathsSupplier {

    public DirectoryPathsSupplier(List<Path> paths) {
        super(paths);
    }

    @Override
    public List<Path> getPaths() throws IOException {
        if (paths.size() != 1) {
            throw new InvalidConfigException("Ambiguous directory name");
        }
        try (var stream = Files.walk(paths.getFirst())) {
            return stream.filter(Files::isRegularFile).toList();
        }
    }
}
