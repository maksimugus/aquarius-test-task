package ru.mchernyaev.att.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCommand implements FileCommand {

    @Override
    public List<List<String>> execute(List<Path> paths) throws IOException {
        List<List<String>> res = new ArrayList<>();
        for (int k = 0; ; k++) {
            var lines = new ArrayList<String>();
            boolean found = false;
            for (int i = 0; i < paths.size(); i++) {
                var path = paths.get(i);
                try (var stream = Files.lines(path).skip(k)) {
                    var line = stream.findFirst().orElse("");
                    if (!line.isEmpty()) found = true;
                    lines.add(preprocess(line, i));
                }
            }
            if (!found) break;
            res.add(lines);
        }
        return res;
    }

    protected abstract String preprocess(String line, int fileNumber);
}
