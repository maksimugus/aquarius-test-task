package ru.mchernyaev.att.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mchernyaev.att.exceptions.InvalidArgumentsNumberException;
import ru.mchernyaev.att.exceptions.InvalidConfigException;
import ru.mchernyaev.att.models.Configuration;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.newBufferedReader;

@Component
@RequiredArgsConstructor
public class ConfigParserImpl implements ConfigParser {
    private final ObjectMapper objectMapper;

    public Configuration parse(String[] args) throws IOException {
        if (args.length != 2) {
            throw new InvalidArgumentsNumberException(2, args.length);
        }

        Path configPath = Paths.get(args[0]);
        if (!Files.exists(configPath)) {
            throw new NoSuchFileException(configPath.toString());
        }

        int configurationNumber = Integer.parseInt(args[1]);
        if (configurationNumber <= 0) {
            throw new IllegalArgumentException("Configuration number should be positive");
        }

        List<Configuration> configurations;
        try (var br = newBufferedReader(configPath, Charset.defaultCharset())) {
            configurations = objectMapper.readValue(br, new TypeReference<>() {
            });
        } catch (MismatchedInputException e) {
            throw new InvalidConfigException(args[0], e);
        }

        if (configurationNumber > configurations.size()) {
            throw new IllegalArgumentException("Configuration number should be in range [1, %d]"
                    .formatted(configurations.size()));
        }

        return configurations.get(configurationNumber - 1);
    }
}
