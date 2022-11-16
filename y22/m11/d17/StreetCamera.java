package m11.d17;

import java.util.*;

public class StreetCamera {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int correctAnswer = 2;

        int answer = solution.solution(routes);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (i1, i2) -> i1[1] - i2[1]);
        List<Integer> camera = new ArrayList<>();
        camera.add(routes[0][1]);
        for (int[] route : routes) {
            if (route[0] > camera.get(camera.size()-1)) {
                camera.add(route[1]);
            }
        }
        return camera.size();
    }
}

class SecondSolution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (i1, i2) -> i1[1] - i2[1]);
        Stack<Integer> camera = new Stack<>();
        camera.add(routes[0][1]);
        for (int[] route : routes) {
            if (route[0] > camera.peek()) {
                camera.add(route[1]);
            }
        }
        return camera.size();
    }
}

class FirstSolution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (i1, i2) -> i1[1] - i2[1]);
        Set<Integer> camera = new HashSet<>();

        for (int[] route : routes) {
            for (int i = route[0]; i <= route[1]; i++) {
                if (camera.contains(i)) {
                    break;
                }
                if (i == route[1]) {
                    camera.add(i);
                }
            }
        }

        return camera.size();
    }
}