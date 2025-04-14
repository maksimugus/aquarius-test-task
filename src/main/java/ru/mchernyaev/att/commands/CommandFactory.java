package ru.mchernyaev.att.commands;

import ru.mchernyaev.att.models.Action;

public interface CommandFactory {
    FileCommand getCommand(Action action);
}
