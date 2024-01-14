package mainClasses;

import java.util.Objects;

public class Abbreviation {
    private String racerName;
    private String teamName;

    public Abbreviation(String racerName, String teamName) {
        this.racerName = racerName;
        this.teamName = teamName;
    }


    public String getRacerName() {
        return racerName;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Abbreviation)) return false;
        Abbreviation that = (Abbreviation) o;
        return Objects.equals(racerName, that.racerName) && Objects.equals(teamName, that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racerName, teamName);
    }
}
