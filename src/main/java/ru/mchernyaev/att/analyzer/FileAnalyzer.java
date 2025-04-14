package ru.mchernyaev.att.analyzer;

import java.io.IOException;
import java.util.List;

public interface FileAnalyzer {
    List<List<String>> analyze() throws IOException;
}
