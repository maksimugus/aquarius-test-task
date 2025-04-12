package ru.mchernyaev.att.analyzer;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import ru.mchernyaev.att.commands.FileCommand;
import ru.mchernyaev.att.strategies.Strategy;

@RequiredArgsConstructor
@Builder(builderClassName = "Builder")
public class FileAnalyzerImpl implements FileAnalyzer {
    private final Strategy strategy;
    private final FileCommand command;

    @Override
    public String analyze() {
        return "";
    }
}
