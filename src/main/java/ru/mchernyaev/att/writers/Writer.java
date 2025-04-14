package ru.mchernyaev.att.writers;

import ru.mchernyaev.att.models.Result;

import java.io.IOException;
import java.nio.file.Path;

public interface Writer {
    Path write(Result result) throws IOException;
}
