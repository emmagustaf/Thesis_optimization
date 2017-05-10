import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    /*
     * This function sorts the disposal history data received into the days of the week and adds it to each inlet.
     */
    public static void sortDays(Map<String,List<Disposal>> disposals) {
        for (String id : disposals.keySet()) {
            Map<DayOfWeek,List<List<Disposal>>> disposalsByWeekDay = new HashMap<>();
            List<List<Disposal>> disposalsByDate = new ArrayList<>();

            // Set date for first list from the first dateTime in the list of all disposals for this inlet
            LocalDateTime firstDateTime = disposals.get(id).get(0).getLogDate();
            LocalDate currentDate = LocalDate.of(firstDateTime.getYear(), firstDateTime.getMonth(), firstDateTime.getDayOfMonth());
            List<Disposal> currentDateDisposals = new ArrayList<>();

            List<List<Disposal>> mon = new ArrayList<>();
            List<List<Disposal>> tue = new ArrayList<>();
            List<List<Disposal>> wed = new ArrayList<>();
            List<List<Disposal>> thu = new ArrayList<>();
            List<List<Disposal>> fri = new ArrayList<>();
            List<List<Disposal>> sat = new ArrayList<>();
            List<List<Disposal>> sun = new ArrayList<>();

            List<Disposal> allDisposals = disposals.get(id);
            for (Disposal d : allDisposals) {
                LocalDateTime dDate = d.getLogDate();
                if (compareDates(dDate,currentDate)) {
                    currentDateDisposals.add(d);
                } else {
                    // Update currentDate to be that of the new disposal
                    currentDate = LocalDate.of(dDate.getYear(),dDate.getMonth(),dDate.getDayOfMonth());

                    // Reset currentDateDisposals to create new list for new date
                    disposalsByDate.add(currentDateDisposals);
                    currentDateDisposals = new ArrayList<>();
                    currentDateDisposals.add(d);
                }
            }

            for (List<Disposal> dayDisposals : disposalsByDate) {
                DayOfWeek day = dayDisposals.get(0).getLogDate().getDayOfWeek();

                switch (day) {
                    case MONDAY:    mon.add(dayDisposals);
                                    break;
                    case TUESDAY:   tue.add(dayDisposals);
                                    break;
                    case WEDNESDAY: wed.add(dayDisposals);
                                    break;
                    case THURSDAY:  thu.add(dayDisposals);
                                    break;
                    case FRIDAY:    fri.add(dayDisposals);
                                    break;
                    case SATURDAY:  sat.add(dayDisposals);
                                    break;
                    case SUNDAY:    sun.add(dayDisposals);
                                    break;
                }

            }

            disposalsByWeekDay.put(DayOfWeek.MONDAY, mon);
            disposalsByWeekDay.put(DayOfWeek.TUESDAY, tue);
            disposalsByWeekDay.put(DayOfWeek.WEDNESDAY, wed);
            disposalsByWeekDay.put(DayOfWeek.THURSDAY, thu);
            disposalsByWeekDay.put(DayOfWeek.FRIDAY, fri);
            disposalsByWeekDay.put(DayOfWeek.SATURDAY, sat);
            disposalsByWeekDay.put(DayOfWeek.SUNDAY, sun);

            SystemSetup.inletsMap.get(id).setDisposals(disposalsByWeekDay);
        }
    }

    /*
     * Returns the average number of disposals made in the given time span
     */
    public static double getDisposalStatsByTime(String inletID, List<DayOfWeek> weekdays, LocalTime start, LocalTime end) {
        Map<DayOfWeek, List<List<Disposal>>> allDisposals = SystemSetup.inletsMap.get(inletID).getDisposals();
        List<List<Disposal>> dayDisposals = new ArrayList<>();
        List<List<Disposal>> newDayDisposals = new ArrayList<>();

        for (DayOfWeek weekday : weekdays) {
            dayDisposals.addAll(allDisposals.get(weekday));
        }

        // Sort out all disposals inside the time span
        if (weekdays.size() == 1 && !(start.equals(LocalTime.of(0,0,0)) && end.equals(LocalTime.of(23,59,59)))) {
            for (List<Disposal> day : dayDisposals) {
                List<Disposal> newDay = new ArrayList<>();

                for (Disposal d : day) {
                    LocalTime time = LocalTime.of(d.getLogDate().getHour(), d.getLogDate().getMinute(), d.getLogDate().getSecond());

                    if (time.isAfter(start) && time.isBefore(end)) {
                        newDay.add(d);
                    } else if (time.isAfter(end)) {
                        break;
                    }
                }

                newDayDisposals.add(newDay);
            }
        } else {
            newDayDisposals = dayDisposals;
        }

        // Check average amount of disposals in the time span
        double totalDisposalAmount = 0;

        for (List<Disposal> day : newDayDisposals) {
            totalDisposalAmount += day.size();
        }

        return totalDisposalAmount/(52 * weekdays.size());  //dayDisposals.size();

    }

    private static boolean compareDates(LocalDateTime disposalDate, LocalDate currentDate) {
        LocalDate temp = LocalDate.of(disposalDate.getYear(), disposalDate.getMonth(), disposalDate.getDayOfMonth());

        return temp.equals(currentDate);
    }

}
