package etc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertArrayAndList {
    public static void main(String[] args) {
        int[] array = new int[5];

        // Array -> List
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        // List -> Array
        // Wrapper 타압
        Integer[] integerList = list.toArray(new Integer[0]);
        Integer[] integerList2 = list.toArray(Integer[]::new);

        // 기본형 타입
//        int[] intList = list.toArray(int[]::new); // 불가능
//        -> intStream 으로 만들어야 함
        int[] intArray = list.stream().mapToInt(Integer::intValue).toArray();

    }
}
