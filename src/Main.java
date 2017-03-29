import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static final String FILENAME = "C:\\Projects\\test29.03\\application.log";

    public static void main(String[] args) {

        Journal j = new Journal();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String currLine = br.readLine().substring(1);
            LogEntry e = new LogEntry(currLine);
            do {
                if (!currLine.isEmpty()) {
                    e = new LogEntry(currLine);
                    j.getJournal().add(e);
                }
            } while ((currLine = br.readLine()) != null);
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }

//        j.getSortedByDate(false);
        j.getFilteredByRequestId("f3845e13");
    }
}
