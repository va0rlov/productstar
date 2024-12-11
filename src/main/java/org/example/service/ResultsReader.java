package org.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.model.Result;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultsReader {

    private final ResultParser resultParser;

    @Autowired
    public ResultsReader(ResultParser resultParser) {
        this.resultParser = resultParser;
    }

    /**
     * Загрузить результаты из файла.
     * <p>
     * Результаты хранятся в формате: Иван Иванов, М, 10 км, 55:20
     */
    public List<Result> readFromFile(Path filePath) {
        try {
            final var collect = Files.lines(filePath)
                    .map(resultParser::parseResult)
                    .collect(Collectors.toList());
            return collect;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
