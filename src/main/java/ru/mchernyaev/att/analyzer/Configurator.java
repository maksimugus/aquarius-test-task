package ru.mchernyaev.att.analyzer;

import lombok.RequiredArgsConstructor;
import ru.mchernyaev.att.models.Configuration;
import ru.mchernyaev.att.strategies.StrategyFactory;

@RequiredArgsConstructor
public class Configurator {
    private final Configuration configuration;
    private final StrategyFactory strategyFactory;

    public void configure(FileAnalyzerImpl.Builder builder) {
        builder.strategy(strategyFactory.getStrategy(configuration.mode()));
    }
}
