package y22.m08.d19;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class FindPrimeNumber {
    public static void main(String[] args) {
        Solution sol1 = new Solution();
        int result1 = sol1.solution("011");
        System.out.println(Objects.equals(result1, 2));

        Solution sol2 = new Solution();
        int result2 = sol2.solution("17");
        System.out.println(Objects.equals(result2, 3));
    }
}

class Solution {
    private HashSet<Integer> set = new HashSet();

    public int solution(String numbers) {
        // 1. numbers 로 만들 수 있는 조합 set 에 저장
        recursive("", numbers);

        // 2. set 에 저장된 값 중 소수의 개수 확인
        int primeNumberCount = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int now = it.next();
            if (isPrimeNumber(now)) {
                primeNumberCount++;
            }
        }
        return primeNumberCount;
    }

    public void recursive(String combination, String others) {
        // 1. 동작
        if (combination.length() != 0) {
            set.add(Integer.parseInt(combination));
        }

        // 2. 재귀 호출
        // 2.1 others 에서 남은 값 모두 확인
        for (int i = 0; i < others.length(); i++) {
            recursive(combination + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    public boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }

        // 소수인지 확인하려면 제곱근 보다 작은 수 까지의 배수만 확인해 보면 됨
        int maxCheckIndex = (int) Math.sqrt(number);
        for (int i = 2; i <= maxCheckIndex; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}

class LectureSolution {
    HashSet<Integer> numbersSet = new HashSet<>();

    public boolean isPrime(int num) {
        // 1. 0과 1은 소수가 아니다
        if (num == 0 || num == 1)
            return false;

        // 2. 에라토스테네스의 체의 limit 숫자를 계산한다.
        int lim = (int) Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 lim까지 배수 여부를 확인한다.
        for (int i = 2; i <= lim; i++)
            if (num % i == 0)
                return false;

        return true;
    }

    public void recursive(String comb, String others) {
        // 1. 현재 조합을 set에 추가한다.
        if (!comb.equals(""))
            numbersSet.add(Integer.valueOf(comb));

        // 2. 남은 숫자 중 한 개를 더해 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++)
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));

    }

    public int solution(String numbers) {
        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);

        // 2. 소수의 개수만 센다.
        int count = 0;
        Iterator<Integer> it = numbersSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number))
                count++;
        }

        // 3. 소수의 개수를 반환한다.
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("117"));
    }
}
