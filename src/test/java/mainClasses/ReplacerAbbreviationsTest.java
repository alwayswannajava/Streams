package mainClasses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ReplacerAbbreviationsTest {

    @Test
    @DisplayName("Test replacing abbreviations #1")
    void testCorrectReplaceAbbriviationsNumberOne() {
        ReplacerAbbreviations replacerAbbreviations = new ReplacerAbbreviations();
        Abbreviation firstAbbreviation = new Abbreviation("Daniel Ricciardo", "RED BULL RACING TAG HEUER");
        Abbreviation secondAbbreviation = new Abbreviation("Sebastian Vettel", "FERRARI");
        Map<String, Abbreviation> inputAbbMap = new LinkedHashMap<>();
        inputAbbMap.put("DRR", firstAbbreviation);
        inputAbbMap.put("SVF", secondAbbreviation);
        Duration firstExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(12).plusNanos(461);
        Duration secondExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(13).plusNanos(265);
        RaceInfo firstRaceInfo = new RaceInfo("Daniel Ricciardo", "RED BULL RACING TAG HEUER", firstExpectedDuration);
        RaceInfo secondRaceInfo = new RaceInfo("Sebastian Vettel", "FERRARI", secondExpectedDuration);
        Map<String, Duration> inputLapsMap = new LinkedHashMap<>();
        inputLapsMap.put("DRR", firstExpectedDuration);
        inputLapsMap.put("SVF", secondExpectedDuration);
        List<RaceInfo> expectedRaceInfoList = new LinkedList<>();
        expectedRaceInfoList.add(firstRaceInfo);
        expectedRaceInfoList.add(secondRaceInfo);
        List<RaceInfo> actualRaceInfoList = replacerAbbreviations.replaceAbbreviations(inputAbbMap, inputLapsMap);
        assertEquals(expectedRaceInfoList, actualRaceInfoList);
    }


}