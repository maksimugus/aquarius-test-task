package ru.mchernyaev.att.analyzer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import ru.mchernyaev.att.exceptions.InvalidArgumentsNumberException;
import ru.mchernyaev.att.models.Configuration;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.newBufferedReader;

public class ConfigParser {
    private final ObjectMapper objectMapper;

    public ConfigParser() {
        objectMapper = JsonMapper.builder()
                .enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS)
                .build();
    }

    public Configuration parse(String[] args) throws NoSuchFileException {
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

        List<Configuration> configurations = List.of();
        try (var br = newBufferedReader(configPath, Charset.defaultCharset())) {
            configurations = objectMapper.readValue(br, new TypeReference<>() {
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (configurationNumber > configurations.size()) {
            throw new IllegalArgumentException("Configuration number should be in range [1, %d]"
                    .formatted(configurations.size()));
        }

        return configurations.get(configurationNumber - 1);
    }
}
