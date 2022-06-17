package y22.m06.d17;

public class PhoneNumber {
    public static void main(String[] args) {
        String str = Solution.solution("01012345678");
        System.out.println("str = " + str);
    }

    // 내 풀이
    static class Solution1 {
        public static String solution(String phone_number) {
            String answer = "";
            int length = phone_number.length();
            for (int i = 0; i < length - 4; i++) {
                answer += "*";
            }
            answer += phone_number.substring(length - 4, length);
            return answer;
        }
    }

    // 다른 사람 풀이
    static class Solution{
        public static String solution(String phone_number) {
            char[] number = phone_number.toCharArray();

            for (int i = 0; i < number.length - 4; i++) {
                number[i] = '*';
            }

            return String.valueOf(number);
        }
    }
}