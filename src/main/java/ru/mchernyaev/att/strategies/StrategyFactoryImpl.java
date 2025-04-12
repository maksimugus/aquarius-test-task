package ru.mchernyaev.att.strategies;

import ru.mchernyaev.att.models.Mode;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactoryImpl implements StrategyFactory {
    private final Map<Mode, Strategy> strategies;

    public StrategyFactoryImpl() {
        strategies = new HashMap<>();
    }

    @Override
    public Strategy getStrategy(Mode mode) {
        return strategies.computeIfAbsent(mode, this::createStrategy);
    }

    private Strategy createStrategy(Mode mode) {
        return switch (mode) {
            case DIR -> new DirStrategy();
            case FILES -> new FilesStrategy();
        };
    }
}
