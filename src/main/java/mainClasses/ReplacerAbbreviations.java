package mainClasses;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class ReplacerAbbreviations {

    public List<RaceInfo> replaceAbbreviations(Map<String, Abbreviation> inputAbbMap, Map<String, Duration> inputLapsMap) {
        return inputAbbMap.entrySet().stream()
                .map(object -> new RaceInfo(object.getValue().getRacerName(),
                        object.getValue().getTeamName(),
                        inputLapsMap.get(object.getKey())))
                .sorted(Comparator.comparing(RaceInfo::getTime))
                .collect(Collectors.toList());
    }
}
