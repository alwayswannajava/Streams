package mainClasses;

import java.time.Duration;
import java.util.Objects;

public class RaceInfo {
    private String driverName;
    private String teamName;
    private Duration time;


    public RaceInfo(String driverName, String teamName, Duration time) {
        this.driverName = driverName;
        this.teamName = teamName;
        this.time = time;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RaceInfo)) return false;
        RaceInfo that = (RaceInfo) o;
        return Objects.equals(driverName, that.driverName) && Objects.equals(teamName, that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverName, teamName, time);
    }
}
