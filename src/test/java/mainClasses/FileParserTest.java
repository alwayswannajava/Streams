package mainClasses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {
    private static final String PATH_TO_START_FILE = "src\\test\\resources\\start.log";
    private static final String PATH_TO_END_FILE = "src\\test\\resources\\end.log";
    private static final String PATH_TO_ABBREVIATIONS_FILE = "src\\test\\resources\\abbreviations.txt";

    @Test
    @DisplayName("Test correct parsing start.log file")
    void testCorrectParseAbbreviationDriverToTimeFile(){
       FileParser fileParser = new FileParser();
       LocalDateTime firstExpectedTime = LocalDateTime.of(2018, 5,24,12,2,58).plus(917L, ChronoUnit.MILLIS);
       LocalDateTime secondExpectedTime = LocalDateTime.of(2018, 5,24,12,2, 49).plus(914L, ChronoUnit.MILLIS);
       DriverTime firstExpectedDriverTime = new DriverTime(firstExpectedTime);
       DriverTime secondExpectedDriverTime = new DriverTime(secondExpectedTime);
       Map<String, DriverTime> expectedMap = new LinkedHashMap<>();
       expectedMap.put("SVF", firstExpectedDriverTime);
       expectedMap.put("NHR", secondExpectedDriverTime);
       Map<String, DriverTime> actualMap = fileParser.parseAbbreviationDriverToTimeFile(PATH_TO_START_FILE);
       assertEquals(expectedMap, actualMap);
    }

    @Test
    @DisplayName("Test correct parsing end.log file")
    void testCorrectParseAbbreviationDriverToTimeFileNumberTwo(){
        FileParser fileParser = new FileParser();
        LocalDateTime firstExpectedTime = LocalDateTime.of(2018, 5,24,12,10,54).plus(750L, ChronoUnit.MILLIS);
        LocalDateTime secondExpectedTime = LocalDateTime.of(2018, 5,24,12,19, 32).plus(585L, ChronoUnit.MILLIS);
        DriverTime firstExpectedDriverTime = new DriverTime(firstExpectedTime);
        DriverTime secondExpectedDriverTime = new DriverTime(secondExpectedTime);
        Map<String, DriverTime> expectedMap = new LinkedHashMap<>();
        expectedMap.put("CLS", firstExpectedDriverTime);
        expectedMap.put("LHM", secondExpectedDriverTime);
        Map<String, DriverTime> actualMap = fileParser.parseAbbreviationDriverToTimeFile(PATH_TO_END_FILE);
        assertEquals(expectedMap, actualMap);
    }
    @Test
    @DisplayName("Test correct parsing abbreviations.txt file")
    void testCorrectParseAbbreviationsFile(){
        FileParser fileParser = new FileParser();
        String firstExpectedString = "DRR";
        String secondExpectedString = "SVF";
        Abbreviation firstExpectedAbbreviation = new Abbreviation("Daniel Ricciardo", "RED BULL RACING TAG HEUER");
        Abbreviation secondExpectedAbbreviation = new Abbreviation("Sebastian Vettel", "FERRARI");
        Map<String, Abbreviation> expectedMap = new LinkedHashMap<>();
        expectedMap.put(firstExpectedString, firstExpectedAbbreviation);
        expectedMap.put(secondExpectedString, secondExpectedAbbreviation);
        Map<String, Abbreviation> actualMap = fileParser.parseAbbreviationsFile(PATH_TO_ABBREVIATIONS_FILE);
        assertEquals(expectedMap, actualMap);
    }


}