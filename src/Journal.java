import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by anch0317 on 29.03.2017.
 */
public class Journal {

    private List<LogEntry> journal;

    public Journal() {
        journal = new LinkedList<>();
    }

    public List<LogEntry> getJournal() {
        return journal;
    }

    public void setJournal(List<LogEntry> journal) {
        this.journal = journal;
    }

    public void getSortedByDate(boolean reverse) {
        int compareFlag;
        if (reverse)  compareFlag = 1;
        else compareFlag = -1;
        List<LogEntry> journal2 = new LinkedList<LogEntry>(journal);
        journal2.sort(new Comparator<LogEntry>() {
            @Override
            public int compare(LogEntry e1, LogEntry e2) {
                LocalDate t1 = e1.getDateTime();
                LocalDate t2 = e2.getDateTime();
                if (t1.isAfter(t2)) return compareFlag;
                else if (!t1.isAfter(t2)) return compareFlag;
                else return 0;
            }
        });
        journal2.forEach(e -> System.out.println(e.getLine()));
    }

    public void getSortedByDateAndLevel() {
        List<LogEntry> journal2 = new LinkedList<LogEntry>(journal);
        //TODO
        journal2.forEach(e -> System.out.println(e.getLine()));
    }

    public void getFilteredByRequestId(String requestId) {
        List<LogEntry> journal2 = new LinkedList<LogEntry>(journal);
        Pattern p = Pattern.compile(".*" + requestId + ".*");
        journal2.forEach(e -> {
            if (p.matcher(e.getLine()).find()) {
                System.out.println(e.getLine());
            }
        });
    }
}
