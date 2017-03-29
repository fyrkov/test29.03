import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by anch0317 on 29.03.2017.
 */
public class LogEntry {

    public LogEntry(String line) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.line = line;
        dateTime = LocalDate.parse(line.substring(0, 10), formatter);
        level = line.substring(24, 30);
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public String getLevel() {
        return level;
    }

    private String line;
    private LocalDate dateTime;
    private String level;
}
