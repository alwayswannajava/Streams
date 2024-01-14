package mainClasses;

import java.time.*;;
import java.util.*;
import java.util.stream.Collectors;

public class LapCalculator {
    public LapCalculator() {

    }

    public Map<String, Duration> calculateBestLap(Map<String, DriverTime> inputStartMap, Map<String, DriverTime> inputEndMap) {
        return inputStartMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        value -> {
                            var startTime = value.getValue().getTime();
                            var endTime = inputEndMap.get(value.getKey()).getTime();
                            return Duration.between(startTime, endTime);
                        }));
    }
}

