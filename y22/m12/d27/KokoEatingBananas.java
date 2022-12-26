package m12.d27;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int correctAnswer = 4;
        int answer = solution.minEatingSpeed(piles, h);
        System.out.println(answer == correctAnswer);
        System.out.println(answer);
    }
}

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            if (calculateEatTime(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public int calculateEatTime(int[] piles, int k) {
        int eatTime = 0;
        for (int pile : piles) {
            if (pile % k == 0) {
                eatTime += pile / k;
            } else {
                eatTime += (pile / k + 1);
            }
        }
        return eatTime;
    }
}


class SolutionFirst {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0;
        int right = Arrays.stream(piles).max().getAsInt();
        int minK = right;

        while (left < right) {
            int mid = (left + right) / 2;

            if (isEatable(piles, h, mid)) {
                right = mid;
                minK = mid;
            } else {
                left = mid + 1;
            }
        }

        return minK;
    }

    // piles 에 있는 바나나를 시간당 k 개씩 먹으면 h 시간 이내에 다 먹을 수 있는가?
    public boolean isEatable(int[] piles, int h, int k) {
        int eatTime = 0;
        for (int pile : piles) {
            eatTime += pile / k;
            if (pile % k != 0) {
                eatTime += 1;
            }
        }
        return eatTime <= h;
    }
}

class SolutionSimply {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int middle = (left + right) / 2;
            int hourSpent = 0;
            for (int pile : piles) {
                hourSpent += Math.ceil((double) pile / middle);
            }

            if (hourSpent <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right;
    }
}
