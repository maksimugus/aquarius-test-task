package ru.mchernyaev.att.commands;

public class ReplaceCommand extends AbstractCommand {

    @Override
    protected String preprocess(String line, int fileNumber) {
        return line.replace("a", String.valueOf(1 + fileNumber))
                .replace("b", String.valueOf(2 + fileNumber))
                .replace("c", String.valueOf(3 + fileNumber));
    }
}
