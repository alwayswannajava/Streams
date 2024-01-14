package mainClasses;

import java.time.Duration;
import java.util.List;
import java.util.OptionalInt;

public class OutputResult {
    private StringBuilder outputResultInfo = new StringBuilder();
    private int correctPosition = 0;
    private static final String MINUTES_SECONDS_MILLIS_FORMAT = "%d:%02d.%03d";

    public String outputResult(List<RaceInfo> outputList) {
        int index = 0;
        findCorrectPosition(outputList);
        for(RaceInfo currentRaceInfo: outputList){
            index++;
            int lengthDriverName = currentRaceInfo.getDriverName().length();
            int lengthTeamName = currentRaceInfo.getTeamName().length();
            Duration time = currentRaceInfo.getTime();
            String formattedTime = String.format(MINUTES_SECONDS_MILLIS_FORMAT, time.toMinutes(), time.toSecondsPart(), time.toMillisPart());
            if(index > 9) {
                outputResultInfo.append(index)
                        .append(". ")
                        .append(currentRaceInfo.getDriverName())
                        .append(drawSpaces(lengthDriverName + 1))
                        .append("|")
                        .append(currentRaceInfo.getTeamName())
                        .append(drawSpaces(lengthTeamName))
                        .append("  |  ")
                        .append(formattedTime)
                        .append("\n");
            }
            else {
                outputResultInfo.append(index)
                        .append(". ")
                        .append(currentRaceInfo.getDriverName())
                        .append(drawSpaces(lengthDriverName))
                        .append("|")
                        .append(currentRaceInfo.getTeamName())
                        .append(drawSpaces(lengthTeamName))
                        .append("  |  ")
                        .append(formattedTime)
                        .append("\n");
            }
            if(index == 15) {
                outputResultInfo.append("--------------------------------------------------------------------")
                .append("\n");
            }
        }
        return outputResultInfo.toString();
    }

    private void findCorrectPosition(List<RaceInfo> inputList){
        OptionalInt maxOpt  = inputList.stream()
                .map(RaceInfo::getTeamName)
                .mapToInt(String::length)
                .max();
        correctPosition = maxOpt.orElse(-1);
    }

    private String drawSpaces(int position) {
        StringBuilder space = new StringBuilder();
        int index = position;
        while(correctPosition != index) {
            if(index > correctPosition){
                space.append(" ");
                break;
            }
            space.append(" ");
            index++;
        }
        return space.toString();
    }

}
