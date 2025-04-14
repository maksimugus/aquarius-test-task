package ru.mchernyaev.att.analyzer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.mchernyaev.att.commands.CommandFactory;
import ru.mchernyaev.att.commands.FileCommand;
import ru.mchernyaev.att.models.Configuration;
import ru.mchernyaev.att.pathssuppliers.PathsSupplier;
import ru.mchernyaev.att.pathssuppliers.PathsSupplierFactory;

@Component
@RequiredArgsConstructor
public class Configurator {
    private final PathsSupplierFactory pathsSupplierFactory;
    private final CommandFactory commandFactory;

    public void configure(
            Configuration configuration,
            FileAnalyzerImpl.Builder builder
    ) {
        builder.pathsSupplier(getSupplier(configuration))
                .command(getCommand(configuration));
    }

    private PathsSupplier getSupplier(Configuration configuration) {
        return pathsSupplierFactory.getSupplier(
                configuration.mode(),
                configuration.paths()
        );
    }

    private FileCommand getCommand(Configuration configuration) {
        return commandFactory.getCommand(configuration.action());
    }
}
