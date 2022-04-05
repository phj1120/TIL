package y22.m03.d12;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Q1924 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] date = s.split(" ");

        DayOfWeek yoil = LocalDate.of(2007, Integer.parseInt(date[0]), Integer.parseInt(date[1])).getDayOfWeek();
        System.out.println("yoil = " + (yoil+"").substring(0, 3));
    }
}
