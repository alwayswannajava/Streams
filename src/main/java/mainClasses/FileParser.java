package mainClasses;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileParser {
    private static final DateTimeFormatter LOCAL_DATE_TIME_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");

    public static void main(String[] args) {
        FileParser fileParser = new FileParser();
        Map<String, DriverTime> startMap = fileParser.parseAbbreviationDriverToTimeFile("src/main/resources/start.log");
        Map<String, DriverTime> endMap = fileParser.parseAbbreviationDriverToTimeFile("src/main/resources/end.log");
        LapCalculator lapCalculator = new LapCalculator();
        Map<String, Duration> lapsMap = lapCalculator.calculateBestLap(startMap, endMap);
        Map<String, Abbreviation> abbreviationsMap = fileParser.parseAbbreviationsFile("src/main/resources/abbreviations.txt");
        ReplacerAbbreviations replacerAbbreviations = new ReplacerAbbreviations();
        List<RaceInfo> raceInfoList = replacerAbbreviations.replaceAbbreviations(abbreviationsMap, lapsMap);
        OutputResult outputResult = new OutputResult();
        System.out.println(outputResult.outputResult(raceInfoList));
    }

    public Map<String, DriverTime> parseAbbreviationDriverToTimeFile(String file) {
        List<String> parsedLines = new ArrayList<>();
        Path pathToFile = Paths.get(file);
        try (Stream<String> lineStream = Files.lines(pathToFile)) {
            parsedLines = lineStream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsedLines.stream()
                .collect(Collectors.toMap(s -> s.substring(0, 3), s -> new DriverTime(LocalDateTime.parse(s.substring(3, 26), LOCAL_DATE_TIME_PATTERN))));
    }


    public Map<String, Abbreviation> parseAbbreviationsFile(String file) {
        List<String> parsedLines = new ArrayList<>();
        Path pathToFile = Paths.get(file);
        try (Stream<String> lineStream = Files.lines(pathToFile)) {
            parsedLines = lineStream.collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsedLines.stream()
                .map(line -> line.split("_"))
                .collect(Collectors.toMap(key -> key[0], value -> new Abbreviation(value[1], value[2])));
    }
}



