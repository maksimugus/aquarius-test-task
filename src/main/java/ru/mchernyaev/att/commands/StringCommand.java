package ru.mchernyaev.att.commands;

public class StringCommand extends AbstractCommand {

    @Override
    protected String preprocess(String line, int fileNumber) {
        return line;
    }
}
