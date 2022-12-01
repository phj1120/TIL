package m12.d01;

import java.util.ArrayList;
import java.util.List;

public class KPrimeNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int correctAnswer = 3;
        int answer = solution.solution(437674, 3);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }

}
class Solution {
    public int solution(int n, int k) {
        // 진법 변환
        String changeSystem = "";
        while (n != 0) {
            changeSystem = (n % k) + changeSystem;
            n /= k;
        }
        // 자르기
        String[] splits = changeSystem.split("0");
        List<Long> datas = new ArrayList<>();
        for (String split : splits) {
            if ("".equals(split)) {
                continue;
            }
            datas.add(Long.parseLong(split));
        }

        // 소수 인지 판단
        int count = 0;
        for (long data : datas) {
            if (isPrimeNumber(data)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrimeNumber(long data) {
        if (data <= 1)
            return false;
        if (data == 2)
            return true;
        long length = (long) Math.sqrt(data) + 1;
        for (long i = 2; i < length; i++) {
            if (data % i == 0) {
                return false;
            }
        }
        return true;
    }
}