package mainClasses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class OutputResultTest {

    @Test
    @DisplayName("Test correct output result #1")
    void testCorrectOutputResultNumberOne(){
        Duration firstExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(12).plusMillis(461);
        Duration secondExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(13).plusMillis(265);
        RaceInfo firstRaceInfo = new RaceInfo("Daniel Ricciardo", "RED BULL RACING TAG HEUER", firstExpectedDuration);
        RaceInfo secondRaceInfo = new RaceInfo("Sebastian Vettel", "FERRARI", secondExpectedDuration);
        List<RaceInfo> RaceInfoList = new LinkedList<>();
        RaceInfoList.add(firstRaceInfo);
        RaceInfoList.add(secondRaceInfo);
        OutputResult outputResult = new OutputResult();
        String expectedOutput = "1. Daniel Ricciardo         |RED BULL RACING TAG HEUER  |  1:12.461\n" +
                "2. Sebastian Vettel         |FERRARI                    |  1:13.265\n";
        String actualOutput = outputResult.outputResult(RaceInfoList);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("Test correct output result #2")
    void testCorrectOutputResultNumberTwo(){
        Duration firstExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(15).plusMillis(321);
        Duration secondExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(17).plusMillis(123);
        RaceInfo firstRaceInfo = new RaceInfo("Lewis Hamilton", "MERCEDES", firstExpectedDuration);
        RaceInfo secondRaceInfo = new RaceInfo("Kimi Raikkonen", "FERRARI", secondExpectedDuration);
        List<RaceInfo> RaceInfoList = new LinkedList<>();
        RaceInfoList.add(firstRaceInfo);
        RaceInfoList.add(secondRaceInfo);
        OutputResult outputResult = new OutputResult();
        String expectedOutput = "1. Lewis Hamilton |MERCEDES  |  1:15.321\n" +
                "2. Kimi Raikkonen |FERRARI   |  1:17.123\n";
        String actualOutput = outputResult.outputResult(RaceInfoList);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("Test correct output result #3")
    void testCorrectOutputResultNumberThree(){
        Duration firstExpectedDuration =  Duration.of(1, ChronoUnit.MINUTES).plusSeconds(13).plusMillis(777);
        Duration secondExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(15).plusMillis(555);
        RaceInfo firstRaceInfo = new RaceInfo("Valtteri Bottas", "MERCEDES", firstExpectedDuration);
        RaceInfo secondRaceInfo = new RaceInfo("Esteban Ocon", "FORCE INDIA MERCEDES", secondExpectedDuration);
        List<RaceInfo> RaceInfoList = new LinkedList<>();
        RaceInfoList.add(firstRaceInfo);
        RaceInfoList.add(secondRaceInfo);
        OutputResult outputResult = new OutputResult();
        String expectedOutput = "1. Valtteri Bottas     |MERCEDES              |  1:13.777\n" +
                "2. Esteban Ocon        |FORCE INDIA MERCEDES  |  1:15.555\n";
        String actualOutput = outputResult.outputResult(RaceInfoList);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @DisplayName("Test correct output line '------' after 15 iteration")
    void testCorrectOutputLineAfterFifteenthIteration(){
        Duration firstExpectedDuration =  Duration.of(1, ChronoUnit.MINUTES).plusSeconds(13).plusMillis(777);
        Duration secondExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(15).plusMillis(555);
        RaceInfo firstRaceInfo = new RaceInfo("Valtteri Bottas", "MERCEDES", firstExpectedDuration);
        RaceInfo secondRaceInfo = new RaceInfo("Esteban Ocon", "FORCE INDIA MERCEDES", secondExpectedDuration);
        List<RaceInfo> RaceInfoList = new LinkedList<>();
        RaceInfoList.add(firstRaceInfo);
        for(int i = 0; i < 15; i++){
            RaceInfoList.add(secondRaceInfo);
        }
        OutputResult outputResult = new OutputResult();
        String expectedOutput = "1. Valtteri Bottas     |MERCEDES              |  1:13.777\n" +
                "2. Esteban Ocon        |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "3. Esteban Ocon        |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "4. Esteban Ocon        |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "5. Esteban Ocon        |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "6. Esteban Ocon        |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "7. Esteban Ocon        |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "8. Esteban Ocon        |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "9. Esteban Ocon        |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "10. Esteban Ocon       |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "11. Esteban Ocon       |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "12. Esteban Ocon       |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "13. Esteban Ocon       |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "14. Esteban Ocon       |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "15. Esteban Ocon       |FORCE INDIA MERCEDES  |  1:15.555\n" +
                "--------------------------------------------------------------------\n" +
                "16. Esteban Ocon       |FORCE INDIA MERCEDES  |  1:15.555\n";
        String actualOutput = outputResult.outputResult(RaceInfoList);
        assertEquals(expectedOutput, actualOutput);
    }
}