package mainClasses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LapCalculatorTest {

    @Test
    @DisplayName("Correct lap calculating #1")
    void testCorrectLapCalculateNumberOne(){
        DriverTime firstStartDriverTime = new DriverTime(LocalDateTime.of(2018,5,24,12,2,58).plus(917L, ChronoUnit.MILLIS));
        DriverTime secondStartDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 2, 49).plus(914L, ChronoUnit.MILLIS));
        DriverTime firstEndDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 4, 3).plus(332L, ChronoUnit.MILLIS));
        DriverTime secondEndDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 4, 2).plus(979L, ChronoUnit.MILLIS));
        Map<String, DriverTime> inputStartMap = new LinkedHashMap<>();
        Map<String, DriverTime> inputEndMap = new LinkedHashMap<>();
        inputStartMap.put("SVF", firstStartDriverTime);
        inputStartMap.put("NHR", secondStartDriverTime);
        inputEndMap.put("SVF", firstEndDriverTime);
        inputEndMap.put("NHR", secondEndDriverTime);
        Duration firstExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(4).plusMillis(415);
        Duration secondExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(13).plusMillis(65);
        Map<String, Duration> expectedMap = new LinkedHashMap<>();
        expectedMap.put("SVF", firstExpectedDuration);
        expectedMap.put("NHR", secondExpectedDuration);
        LapCalculator lapCalculator = new LapCalculator();
        Map<String, Duration> actualMap = lapCalculator.calculateBestLap(inputStartMap, inputEndMap);
        assertEquals(expectedMap, actualMap);
    }

    @Test
    @DisplayName("Correct lap calculating #2")
    void testCorrectLapCalculateNumberTwo(){
        DriverTime firstStartDriverTime = new DriverTime(LocalDateTime.of(2018,5,24,12,13,4).plus(512L, ChronoUnit.MILLIS));
        DriverTime secondStartDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 3, 1).plus(250L, ChronoUnit.MILLIS));
        DriverTime firstEndDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 14, 17).plus(169L, ChronoUnit.MILLIS));
        DriverTime secondEndDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 4, 13).plus(889L, ChronoUnit.MILLIS));
        Map<String, DriverTime> inputStartMap = new LinkedHashMap<>();
        Map<String, DriverTime> inputEndMap = new LinkedHashMap<>();
        inputStartMap.put("FAM", firstStartDriverTime);
        inputStartMap.put("KRF", secondStartDriverTime);
        inputEndMap.put("FAM", firstEndDriverTime);
        inputEndMap.put("KRF", secondEndDriverTime);
        Duration firstExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(12).plusMillis(657);
        Duration secondExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(12).plusMillis(639);
        Map<String, Duration> expectedMap = new LinkedHashMap<>();
        expectedMap.put("FAM", firstExpectedDuration);
        expectedMap.put("KRF", secondExpectedDuration);
        LapCalculator lapCalculator = new LapCalculator();
        Map<String, Duration> actualMap = lapCalculator.calculateBestLap(inputStartMap, inputEndMap);
        assertEquals(expectedMap, actualMap);
    }

    @Test
    @DisplayName("Correct lap calculating #3")
    void testCorrectLapCalculateNumberThree(){
        DriverTime firstStartDriverTime = new DriverTime(LocalDateTime.of(2018,5,24,12,18,37).plus(737L, ChronoUnit.MILLIS));
        DriverTime secondStartDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 4, 45).plus(513L, ChronoUnit.MILLIS));
        DriverTime firstEndDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 19, 50).plus(198L, ChronoUnit.MILLIS));
        DriverTime secondEndDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 5, 58).plus(778L, ChronoUnit.MILLIS));
        Map<String, DriverTime> inputStartMap = new LinkedHashMap<>();
        Map<String, DriverTime> inputEndMap = new LinkedHashMap<>();
        inputStartMap.put("SVM", firstStartDriverTime);
        inputStartMap.put("MES", secondStartDriverTime);
        inputEndMap.put("SVM", firstEndDriverTime);
        inputEndMap.put("MES", secondEndDriverTime);
        Duration firstExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(12).plusMillis(461);
        Duration secondExpectedDuration = Duration.of(1, ChronoUnit.MINUTES).plusSeconds(13).plusMillis(265);
        Map<String, Duration> expectedMap = new LinkedHashMap<>();
        expectedMap.put("SVM", firstExpectedDuration);
        expectedMap.put("MES", secondExpectedDuration);
        LapCalculator lapCalculator = new LapCalculator();
        Map<String, Duration> actualMap = lapCalculator.calculateBestLap(inputStartMap, inputEndMap);
        assertEquals(expectedMap, actualMap);
    }


    @Test
    @DisplayName("Start laps doesn't contain abbreviation in end laps")
    void testThrowNullPointerExceptionWhenStartLapAbbrDoesntContainEndLapAbbr(){
        DriverTime firstStartDriverTime = new DriverTime(LocalDateTime.of(2018,5,24,12,18,37).plus(737L, ChronoUnit.MILLIS));
        DriverTime secondStartDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 4, 45).plus(513L, ChronoUnit.MILLIS));
        DriverTime firstEndDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 19, 50).plus(198L, ChronoUnit.MILLIS));
        DriverTime secondEndDriverTime = new DriverTime(LocalDateTime.of(2018, 5, 24, 12, 5, 58).plus(778L, ChronoUnit.MILLIS));
        Map<String, DriverTime> inputStartMap = new LinkedHashMap<>();
        Map<String, DriverTime> inputEndMap = new LinkedHashMap<>();
        inputStartMap.put("KFC", firstStartDriverTime);
        inputStartMap.put("BUF", secondStartDriverTime);
        inputEndMap.put("SVM", firstEndDriverTime);
        inputEndMap.put("MES", secondEndDriverTime);
        LapCalculator lapCalculator = new LapCalculator();
        assertThrows(NullPointerException.class, () -> {
            lapCalculator.calculateBestLap(inputStartMap, inputEndMap);
        });
    }
}