package y22.m11.d04;

public class Square {

    public static void main(String[] args) {
        Solution solution = new Solution();
        long answer = solution.solution(8, 12);
        System.out.println(answer);
    }

    static class Solution {
        public long solution(int w, int h) {
            // x 를 증가 시켜 가면서 y 가 정수가 되도록
            int setX = -1, setY = -1;
            for (int x = 1; x <= w; x++) {
                double y = intToLong(h) * x / (double) w;
                if (isInteger(y)) {
                    setX = x;
                    setY = (int) y;
                    break;
                }
            }
            int setNum = w / setX;

            // 세트 중 멀쩡한 사각형의 개수
            long countOfSquareInSet = 0;
            for (int i = 1; i < setX; i++) {
                countOfSquareInSet += 2 * (int) (intToLong(h) * i / (double) w);
            }

            // (전체 사각형의 개수) - (세트에서 잘린 사각형의 세트) * (세트 수)
            return w * intToLong(h) - ((intToLong(setX) * setY - countOfSquareInSet) * setNum);
        }

        public boolean isInteger(double y) {
            return y - (int) y == 0;
        }

        public long intToLong(int i) {
            return (long) i;
        }
    }
}
