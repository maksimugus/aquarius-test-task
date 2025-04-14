package ru.mchernyaev.att.commands;

public class CountCommand extends AbstractCommand {

    @Override
    protected String preprocess(String line, int fileNumber) {
        if (line.isEmpty()) return "0";
        return String.valueOf(line.split("\\s+").length);
    }
}
