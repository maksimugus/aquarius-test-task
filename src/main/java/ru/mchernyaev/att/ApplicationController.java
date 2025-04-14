package ru.mchernyaev.att;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mchernyaev.att.analyzer.Configurator;
import ru.mchernyaev.att.analyzer.FileAnalyzerImpl;
import ru.mchernyaev.att.models.Result;
import ru.mchernyaev.att.parser.ConfigParser;
import ru.mchernyaev.att.writers.Writer;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ApplicationController {
    private final ConfigParser configParser;
    private final Configurator configurator;
    private final Writer resultWriter;

    public void run(String[] args) throws IOException {
        var configuration = configParser.parse(args);
        var builder = FileAnalyzerImpl.builder();
        configurator.configure(configuration, builder);
        var analyzer = builder.build();
        var results = analyzer.analyze();
        var result = new Result(
                args[0],
                Integer.parseInt(args[1]),
                configuration,
                results
        );
        var pathToResult = resultWriter.write(result);
        System.out.println(pathToResult);
    }
}
