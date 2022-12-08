package y22.m12.d08;

import java.util.Arrays;
import java.util.List;

public class Robot {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String command = "GRGLGRG";
        int[] correctAnswer = {2, 2};
        int[] answer = solution.solution(command);
        System.out.println(Arrays.equals(correctAnswer, answer));
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    List<Character> fourDirection = List.of('N', 'E', 'S', 'W');
    List<List<Integer>> go = List.of(List.of(0, 1), List.of(1, 0), List.of(0, -1), List.of(-1, 0));
    List<List<Integer>> back = List.of(List.of(0, -1), List.of(-1, 0), List.of(0, 1), List.of(1, 0));

    public int[] solution(String command) {
        char direction = 'N';
        int x = 0, y = 0;

        for (char nowCommand : command.toCharArray()) {
            // 방향 전환 일 경우
            if (isDirection(nowCommand)) {
                direction = changeDirection(direction, nowCommand);
                continue;
            }

            // 전진 일 경우
            int nowDirectionIndex = fourDirection.indexOf(direction);
            if (nowCommand == 'G') {
                List<Integer> move = go.get(nowDirectionIndex);
                x += move.get(0);
                y += move.get(1);
                continue;
            }


            // 후진 일 경우
            List<Integer> move = back.get(nowDirectionIndex);
            x += move.get(0);
            y += move.get(1);
        }

        return new int[]{x, y};
    }

    private char changeDirection(char direction, char command) {
        if (command == 'R') {
            return fourDirection.get(linearToCircle(fourDirection.indexOf(direction) + 1, fourDirection.size()));
        }
        return fourDirection.get(linearToCircle(fourDirection.indexOf(direction) - 1, fourDirection.size()));
    }

    private int linearToCircle(int index, int size) {
        if (index == -1)
            return size - 1;
        if (index == size)
            return 0;
        return index;
    }

    private boolean isDirection(char now) {
        return now == 'R' || now == 'L';
    }
}
