import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ParseData {

    public static Map<String,List<Disposal>> parseCSVFile(String filePath) {
        String delimiter = ";";
        Map<String, List<Disposal>> disposalsPerInlet = new HashMap<>();

        BufferedReader buff = null;

        try {
            String buffLine;
            buff = new BufferedReader(new FileReader(filePath));

            while ((buffLine = buff.readLine()) != null) {
                String[] split = buffLine.split(delimiter);

                // We don't want the "fake"-disposals with customer-is starting with 00000000
                if (!split[5].startsWith("00000000")) {
                    String logId = split[0];
                    LocalDateTime logDate = parseDate(split[2]);
                    String inletId = split[8];
                    inletId = inletId.substring(0, inletId.lastIndexOf(':'));

                    List<Disposal> newList = disposalsPerInlet.get(inletId);
                    if(newList == null) {
                        newList = new ArrayList<>();
                    }

                    newList.add(new Disposal(logId, logDate, inletId));
                    disposalsPerInlet.put(inletId, newList);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (buff != null) buff.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return disposalsPerInlet;

    }

    public static LocalDateTime parseDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);
        LocalDateTime date = LocalDateTime.parse(dateString, formatter);
        return date;
    }
}