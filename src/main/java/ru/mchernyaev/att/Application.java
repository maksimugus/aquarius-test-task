package ru.mchernyaev.att;

import ru.mchernyaev.att.analyzer.ConfigParser;
import ru.mchernyaev.att.analyzer.Configurator;
import ru.mchernyaev.att.analyzer.FileAnalyzerImpl;
import ru.mchernyaev.att.strategies.StrategyFactoryImpl;

import java.nio.file.NoSuchFileException;

public class Application {
    public static void main(String[] args) throws NoSuchFileException {
        var parser = new ConfigParser();
        var configuration = parser.parse(args);
        var factory = new StrategyFactoryImpl();
        var configurator = new Configurator(configuration, factory);
        var builder = FileAnalyzerImpl.builder();
        configurator.configure(builder);
        var analyzer = builder.build();
        var path = analyzer.analyze();
        System.out.println(path);
    }
}
