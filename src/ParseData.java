import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class ParseData {

    public static Map<String,List<Disposal>> parseCSVFile(String filePath) {
        String delimiter = ";";
        Map<String, List<Disposal>> disposalsPerInlet = new HashMap<>();

        BufferedReader buff = null;

        try {
            String buffLine;
            buff = new BufferedReader(new FileReader(filePath));
            //int nbrOfConseqDisposals = 0;
            Tuple<String,List<Disposal>> conseqDisposals = null;

            while ((buffLine = buff.readLine()) != null) {
                String[] split = buffLine.split(delimiter);
                String logId = split[0];
                LocalDateTime logDate = parseDate(split[2]);
                String customerId = split[5];
                String tagId = split[6];
                String weigth = split[7];
                String inletId = split[8];
                inletId = inletId.substring(0, inletId.lastIndexOf(':'));

                // We don't want the "fake"-disposals with customer-id starting with 00000000
                if (!customerId.startsWith("0000000") && !tagId.equals("") && weigth.equals("-1")) {

                    if (conseqDisposals != null) {  // If conseqDisposals has been initialized
                        if ((conseqDisposals.x).equals(tagId) && (conseqDisposals.y.get(0).getInletAddress()).equals(inletId)) {    // If this disposal is made by the same user as the one before
                            List<Disposal> newList = new ArrayList<>(conseqDisposals.y);
                            newList.add(new Disposal(logId, logDate, inletId));
                            conseqDisposals = new Tuple<>(tagId, newList);

                        } else {
                            long secondsDifference = ChronoUnit.SECONDS.between(conseqDisposals.y.get(0).getLogDate(), conseqDisposals.y.get(conseqDisposals.y.size() - 1).getLogDate());
                            long nbrOfDisposals = conseqDisposals.y.size();
                            long secondsBetweenDisposals = secondsDifference/nbrOfDisposals;

                            List<Disposal> newList = disposalsPerInlet.get(inletId);
                            if(newList == null) {
                                newList = new ArrayList<>();
                            }

                            if (conseqDisposals.y.size() > 1 && secondsBetweenDisposals < 5) { // Something is weird with these disposals, only save the first one
                                newList.add(conseqDisposals.y.get(0));
                            } else {    // Add all if nothing seems weird
                                newList.addAll(conseqDisposals.y);
                            }

                            disposalsPerInlet.put(inletId, newList);

                            List<Disposal> conseqList = Arrays.asList(new Disposal(logId, logDate, inletId));
                            conseqDisposals = new Tuple<>(tagId, conseqList);    // New sequence
                        }

                        // Är detta samma id? Lägg isf till i listan. annars: Hur många ligger det i listan? Ska några tas bort?
                    } else {
                        conseqDisposals = new Tuple<>(tagId, Arrays.asList(new Disposal(logId, logDate, inletId)));
                        // Stoppa in detta id i listan
                    }



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