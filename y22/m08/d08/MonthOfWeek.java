package y22.m08.d08;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class MonthOfWeek {
    public static void main(String[] args) {
//        for (int i = 1; i <= 30; i++) {
//            Calendar c = Calendar.getInstance();
//            c.set(2022, Calendar.FEBRUARY, i);
//
//            System.out.println(i + " = " + c.get(Calendar.WEEK_OF_MONTH));
//        }

//        int year = now.getYear();
//        int month = now.getMonthValue();
//        int dayOfWeekValue = now.getDayOfWeek().getValue();
//        int dayOfMonth = now.getDayOfMonth();
//        LocalDate startLocalDate = now.withDayOfMonth(1);
//        LocalDate endLocalDate = now.withDayOfMonth(now.lengthOfMonth());
//
//        System.out.println("year = " + year);
//        System.out.println("month = " + month);
//        System.out.println("dayOfWeekValue = " + dayOfWeekValue);
//        System.out.println("dayOfMonth = " + dayOfMonth);
//        System.out.println("endLocalDate = " + endLocalDate);
//        System.out.println("startLocalDate = " + startLocalDate);

        LocalDate now = LocalDate.now();
        now = LocalDate.of(2022, 8, 1);

        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalDate dayOfWeekForMonday = now.minusDays(dayOfWeek.getValue() - 1);
        LocalDate dayOfWeekForSunday = now.plusDays(7 - dayOfWeek.getValue());

        System.out.println("now = " + now + " " + now.getDayOfWeek());
        System.out.println("dayOfWeekForMonday = " + dayOfWeekForMonday + " " + dayOfWeekForMonday.getDayOfWeek());
        System.out.println("dayOfWeekForSunday = " + dayOfWeekForSunday + " " + dayOfWeekForSunday.getDayOfWeek());

        Period period = new Period();
        if (dayOfWeekForMonday.getMonth() == dayOfWeekForSunday.getMonth()) {
            LocalDate firstDay = LocalDate.of(now.getYear(), now.getMonth(), 1);

            int week;
            if (firstDay.getDayOfWeek().getValue() <= DayOfWeek.THURSDAY.getValue()) {
                week = (now.getDayOfMonth() + firstDay.getDayOfWeek().getValue() - 1) / 7 + 1;
            } else {
                week = (now.getDayOfMonth() + firstDay.getDayOfWeek().getValue() - 1) / 7;
            }
            period.setWeek(week);
            period.setYear(now.getYear());
            period.setMonth(now.getMonth().getValue());
            period.setDayOfMonth(now.getDayOfMonth());
            period.setDayOfWeek(now.getDayOfWeek().getValue());
        }
        System.out.println("period = " + period);

    }
}

class Period {
    private int year;
    private int month;
    private int DayOfMonth;
    private int DayOfWeek;
    private int week;

    public Period() {
    }

    @Override
    public String toString() {
        return "Period{" +
                "year=" + year +
                ", month=" + month +
                ", DayOfMonth=" + DayOfMonth +
                ", week=" + week +
                ", DayOfWeek=" + DayOfWeek +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDayOfMonth() {
        return DayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.DayOfMonth = dayOfMonth;
    }

    public int getDayOfWeek() {
        return DayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.DayOfWeek = dayOfWeek;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}