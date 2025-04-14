package ru.mchernyaev.att.commands;

import ru.mchernyaev.att.models.Action;

public class CommandFactoryImpl implements CommandFactory {

    @Override
    public FileCommand getCommand(Action action) {
        return switch (action) {
            case STRING -> new StringCommand();
            case COUNT -> new CountCommand();
            case REPLACE -> new ReplaceCommand();
        };
    }
}
