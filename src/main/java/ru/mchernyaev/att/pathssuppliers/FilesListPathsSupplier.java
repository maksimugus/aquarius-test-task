package ru.mchernyaev.att.pathssuppliers;

import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

public class FilesListPathsSupplier extends AbstractPathsSupplier {
    public FilesListPathsSupplier(List<Path> paths) {
        super(paths);
    }

    @Override
    public List<Path> getPaths() throws NoSuchFileException {
        var nonexistent_file = paths.stream()
                .filter(Files::exists)
                .findFirst();
        if (nonexistent_file.isEmpty()) {
            return paths;
        }
        throw new NoSuchFileException(nonexistent_file.get().toString());
    }
}
