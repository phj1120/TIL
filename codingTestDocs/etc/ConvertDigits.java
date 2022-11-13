package etc;

import java.util.ArrayList;
import java.util.List;

public class ConvertDigits {
    public int[] convertDigits(int number) {
        String str = String.valueOf(number);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
    }

    public List<Integer> convertDigitsList(int number) {
        List<Integer> digitList = new ArrayList<>();
        while (number != 0) {
            digitList.add(0, number % 10);
            number /= 10;
        }
        return digitList;
    }
}
