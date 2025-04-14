package ru.mchernyaev.att.models;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.nio.file.Path;
import java.util.List;

@Builder
@RequiredArgsConstructor
public class Result {
    private final String configFilePath;
    private final String configurationId;
    private final Configuration configurationData;
    private final List<List<String>> results;
}
