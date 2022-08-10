package y22.m08.d10;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class MonthOfWeek {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        now = LocalDate.of(2022, 10, 17);

        LocalDate mondayOfDate = now.minusDays(now.getDayOfWeek().getValue() - 1);
        LocalDate sundayOfDate = now.plusDays(7 - now.getDayOfWeek().getValue());
        LocalDate thursdayOfDate = now.minusDays(now.getDayOfWeek().getValue() - 4);
        LocalDate firstThursdayOfDate = null;

        for (int i = 1; i <= 7; i++) {
            LocalDate date = thursdayOfDate.withDayOfMonth(i);
            if (date.getDayOfWeek() == DayOfWeek.THURSDAY) {
                firstThursdayOfDate = date;
                break;
            }
        }

        int year = thursdayOfDate.getYear();
        int month = thursdayOfDate.getMonth().getValue();
        int week = (thursdayOfDate.getDayOfMonth() - firstThursdayOfDate.getDayOfMonth()) / 7 + 1;

        Period period = new Period();
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