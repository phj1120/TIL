package y22.m09.d11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Coordinate> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] data = line.split(" ");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);
            Coordinate coordinate = new Coordinate(x, y);
            list.add(coordinate);
        }

        Collections.sort(list, ((o1, o2) -> {
            Coordinate c1 = (Coordinate) o1;
            Coordinate c2 = (Coordinate) o2;
            return c1.compareTo(c2);
        }));

        for (Coordinate coordinate : list) {
            System.out.println(coordinate.x + " " + coordinate.y);
        }
    }
}

class Coordinate implements Comparable {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        Coordinate c = (Coordinate) o;
        if (this.x == c.x) {
            return this.y - c.y;
        }
        return this.x - c.x;
    }
}


