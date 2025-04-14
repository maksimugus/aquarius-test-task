package ru.mchernyaev.att.analyzer;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import ru.mchernyaev.att.commands.FileCommand;
import ru.mchernyaev.att.pathssuppliers.PathsSupplier;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Builder(builderClassName = "Builder")
public class FileAnalyzerImpl implements FileAnalyzer {
    private final PathsSupplier pathsSupplier;
    private final FileCommand command;

    @Override
    public List<List<String>> analyze() throws IOException {
        var files = pathsSupplier.getPaths();
        return command.execute(files);
    }
}
