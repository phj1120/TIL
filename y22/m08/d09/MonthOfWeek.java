package y22.m08.d09;

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

        Period period = new Period();
        int year = 0;
        int month = 0;
        int week = 0;

        LocalDate firstDay = now.withDayOfMonth(1);
        LocalDate lastDay = now.withDayOfMonth(now.lengthOfMonth());

        LocalDate dayOfWeekForMonday = now.minusDays(now.getDayOfWeek().getValue() - 1);
        LocalDate dayOfWeekForSunday = now.plusDays(7 - now.getDayOfWeek().getValue());
        LocalDate firstDayForSunday = firstDay.plusDays(7 - firstDay.getDayOfWeek().getValue());
        LocalDate lastDayForMonDay = lastDay.minusDays(lastDay.getDayOfWeek().getValue() - 1);

        if (dayOfWeekForMonday.getMonth() == dayOfWeekForSunday.getMonth()) {
            year = now.getYear();
            month = now.getMonth().getValue();
            if (firstDay.getDayOfWeek().getValue() <= DayOfWeek.THURSDAY.getValue()) {
                week = (now.getDayOfMonth() + firstDay.getDayOfWeek().getValue() - 1) / 7 + 1;
            } else {
                week = (now.getDayOfMonth() + firstDay.getDayOfWeek().getValue() - 1) / 7;
            }
        } else if (now.getDayOfMonth() <= firstDayForSunday.getDayOfMonth()) {
            if (firstDay.getDayOfWeek().getValue() <= DayOfWeek.THURSDAY.getValue()) {
                year = 0;
                month = 0;
                week = 0;
            } else {
                year = 1;
                month =1;
                week = 1;
            }
        } else if (now.getDayOfMonth() >= lastDayForMonDay.getDayOfMonth()) {
            if (firstDay.getDayOfWeek().getValue() <= DayOfWeek.THURSDAY.getValue()) {
                year = 0;
                month = 0;
                week = 0;
            } else {
                year = 1;
                month =1;
                week = 1;
            }
        }

        period.setYear(year);
        period.setMonth(month);
        period.setWeek(week);
        System.out.println("period = " + period);

    }
}

class Period {
    private int year;
    private int month;
    private int week;

    public Period() {
    }

    @Override
    public String toString() {
        return "Period{" +
                "year=" + year +
                ", month=" + month +
                ", week=" + week +
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

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}