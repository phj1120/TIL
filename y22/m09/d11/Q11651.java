package y22.m09.d11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Coordinate2> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] data = line.split(" ");
            int x = Integer.parseInt(data[0]);
            int y = Integer.parseInt(data[1]);
            Coordinate2 coordinate = new Coordinate2(x, y);
            list.add(coordinate);
        }

        Collections.sort(list, ((o1, o2) -> {
            Coordinate2 c1 = (Coordinate2) o1;
            Coordinate2 c2 = (Coordinate2) o2;
            return c1.compareTo(c2);
        }));

        for (Coordinate2 coordinate : list) {
            System.out.println(coordinate.x + " " + coordinate.y);
        }
    }
}

class Coordinate2 implements Comparable {
    public int x;
    public int y;

    public Coordinate2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        Coordinate2 c = (Coordinate2) o;
        if (this.y == c.y) {
            return this.x - c.x;
        }
        return this.y - c.y;
    }
}


