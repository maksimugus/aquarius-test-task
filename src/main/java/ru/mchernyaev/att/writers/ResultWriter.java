package ru.mchernyaev.att.writers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mchernyaev.att.models.Result;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
@RequiredArgsConstructor
public class ResultWriter implements Writer {
    private static final String DIR = "testdir/out";
    private final ObjectMapper objectMapper;

    @Override
    public Path write(Result result) throws IOException {
        var resultPath = Files.createTempFile(Path.of(DIR),"result", ".json");
        try(var bw = Files.newBufferedWriter(resultPath)) {
            objectMapper.writeValue(bw, result);
        }
        return resultPath;
    }
}
