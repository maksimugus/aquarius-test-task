package ru.mchernyaev.att.models;

import java.util.List;

public record Result(
        String configFilePath,
        int configurationId,
        Configuration configurationData,
        List<List<String>> results
) {
}
