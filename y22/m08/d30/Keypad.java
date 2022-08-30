package y22.m08.d30;

public class Keypad {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String result = "LRLLLRLLRRL";
        String answer = solution.solution(numbers, hand);
        System.out.println(result.equals(answer));
    }
}

class Solution {
    Position left;
    Position right;
    Position numPos;

    public String solution(int[] numbers, String hand) {
        String answer = "";
        left = new Position(3, 0);
        right = new Position(3, 2);

        for (int num : numbers) {
            numPos = new Position((num - 1) / 3, (num - 1) % 3);
            if (num == 0)
                numPos = new Position(3, 1);
            String finger = numPos.getFinger(hand);

            answer += finger;
            if (finger.equals("L")) {
                left = numPos;
            } else {
                right = numPos;
            }
        }

        return answer;
    }

    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand) {
            String finger = hand.equals("right") ? "R" : "L";

            if (this.col == 0) {
                finger = "L";
            } else if (this.col == 2) {
                finger = "R";
            } else {
                int leftDistance = left.getDistance(this);
                int rightDistance = right.getDistance(this);

                if (leftDistance < rightDistance) {
                    finger = "L";
                } else if (rightDistance < leftDistance) {
                    finger = "R";
                }
            }
            return finger;
        }

        public int getDistance(Position p) {
            return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
        }
    }
}