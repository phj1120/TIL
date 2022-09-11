package y22.m09.d11;

import java.util.Arrays;

public class PracComparator {
    public static void main(String[] args) {

        // 문자열의 두번째 문자로 내림차순 정렬
        String[] arr = {"AAAA", "ABBB", "ACCC"};
        Arrays.sort(arr, ((o1, o2) -> {
            if (o1 instanceof String && o2 instanceof String) {
                Character c1 = o1.charAt(1);
                Character c2 = o2.charAt(1);
//                return c1 > c2 ? -1 : (c1 == c2) ? 0 : 1;
//                return c2.compareTo(c1);
                // 0 : 기준값 == 비교값
                // 1 : 기준값 > 비교값
                // -1 : 기준값 < 비교값
                // (기준값 - 비교값) 이라 생각하면 편함
                return c1.compareTo(c2) * -1;
            }
            return -1;
        }));
        System.out.println(Arrays.toString(arr));
    }
}
