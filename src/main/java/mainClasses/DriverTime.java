package mainClasses;

import java.time.LocalDateTime;
import java.util.Objects;

public class DriverTime {
    private LocalDateTime time;

    public DriverTime(LocalDateTime time) {
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriverTime)) return false;
        DriverTime that = (DriverTime) o;
        return Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }
}
