package y22.m09.d30;

class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for (int[] size : sizes) {
            int w;
            int h;

            if (size[0] > size[1]) {
                w = size[0];
                h = size[1];
            } else {
                w = size[1];
                h = size[0];
            }

            if (maxW < w) {
                maxW = w;
            }
            if (maxH < h) {
                maxH = h;
            }
        }
        return maxW * maxH;
    }
}

class BetterSolution {
    public int solution(int[][] sizes) {
        int maxW = 0, maxH = 0;

        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);

            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        return maxW * maxH;
    }
}

public class MinSquare {

}
