package ru.mchernyaev.att;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import ru.mchernyaev.att.analyzer.Configurator;
import ru.mchernyaev.att.analyzer.FileAnalyzerImpl;
import ru.mchernyaev.att.commands.CommandFactory;
import ru.mchernyaev.att.commands.CommandFactoryImpl;
import ru.mchernyaev.att.models.Result;
import ru.mchernyaev.att.parser.ConfigParser;
import ru.mchernyaev.att.parser.ConfigParserImpl;
import ru.mchernyaev.att.pathssuppliers.PathsSupplierFactory;
import ru.mchernyaev.att.pathssuppliers.PathsSupplierFactoryImpl;
import ru.mchernyaev.att.writers.ResultWriter;
import ru.mchernyaev.att.writers.Writer;

import java.io.IOException;

public class ApplicationController {
    private final ConfigParser configParser;
    private final Configurator configurator;
    private final Writer resultWriter;

    public ApplicationController(
            ConfigParser configParser,
            PathsSupplierFactory pathsSupplierFactory,
            CommandFactory commandFactory,
            Writer resultWriter
    ) {
        this.configParser = configParser;
        configurator = new Configurator(pathsSupplierFactory, commandFactory);
        this.resultWriter = resultWriter;
    }

    public static ApplicationController getDefault() {
        var mapper = JsonMapper.builder()
                .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
                .build();
        return new ApplicationController(
                new ConfigParserImpl(mapper),
                new PathsSupplierFactoryImpl(),
                new CommandFactoryImpl(),
                new ResultWriter(mapper)
        );
    }

    public void run(String[] args) throws IOException {
        var configuration = configParser.parse(args);
        var builder = FileAnalyzerImpl.builder();
        configurator.configure(configuration, builder);
        var analyzer = builder.build();
        var results = analyzer.analyze();
        var result = Result.builder()
                .configFilePath(args[0])
                .configurationId(args[1])
                .configurationData(configuration)
                .results(results)
                .build();
        var pathToResult = resultWriter.write(result);
        System.out.println(pathToResult);
    }
}
