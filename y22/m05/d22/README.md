# 2022.05.22.

음... 일단 여기까지...

char[] 에서 몇 번째 원소인지 찾는걸 오래 걸렸다.

python 이면 금방 할 텐데...

리스트로 바꿔서 몇번째 index 인지 구하려고 Arrays.asList(arr) 했는데

    List<char[]> chars = Arrays.asList(arr);

원하는 대로 되지 않음

char[] 이면 배열 아닌가? 검색해 보니까 그냥 되는 것 같던데

    char[] arrChar = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    List<char[]> chars = Arrays.asList(arrChar);

    Character[] arrCharacter = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    List<Character> chars1 = Arrays.asList(arrCharacter);

    int[] arrInt = {1, 2, 3, 4, 5};
    List<int[]> ints = Arrays.asList(arrInt);

    Integer[] arrInteger = {1, 2, 3, 4, 5};
    List<Integer> integers = Arrays.asList(arrInteger);

기본 자료형 말고 Wrapper class 였구나...

    String strArr = new String(arr);
    int idxA = strArr.indexOf(str.charAt(0));

String 으로 바꿔서 이렇게 해결 했음

읽어보면 좋을 것

[Array와 ArrayList의 차이점](https://ko.strephonsays.com/what-is-the-difference-between-array-and-arraylist)

## 아이디어

조건을 충족하면 cnt++ 하는 것을 어디에 둬야할지 지금 막힘

내일 다시 생각해 봐야겠다.

## Reference

https://codechacha.com/ko/java-convert-chararray-to-string/

https://jamesdreaming.tistory.com/82

https://stackoverflow.com/questions/15590675/converting-char-array-to-list-in-java

https://coderanch.com/t/534080/java/Arrays-asList-character-array