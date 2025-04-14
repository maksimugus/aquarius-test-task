package ru.mchernyaev.att.writers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import ru.mchernyaev.att.models.Result;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

@RequiredArgsConstructor
public class ResultWriter implements Writer {
    private static final String PATH_TEMPLATE = "src/main/resources/%s.json";
    private final ObjectMapper objectMapper;

    @Override
    public Path write(Result result) throws IOException {
        var resultPath = Path.of(PATH_TEMPLATE.formatted(LocalDate.now()));
        try(var bw = Files.newBufferedWriter(resultPath)) {
            objectMapper.writeValue(bw, result);
        }
        return resultPath;
    }
}
