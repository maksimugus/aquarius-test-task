package ru.mchernyaev.att.strategies;

import ru.mchernyaev.att.models.Mode;

public interface StrategyFactory {
    Strategy getStrategy(Mode mode);
}
