package y22.m08.d21;

import java.util.*;

public class PhoneNumberList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] phoneBook = {"219", "97674223", "4195524421", "119", "37674223", "1195524421"};
        boolean answer = false;
        boolean result = solution.solution(phoneBook);

        System.out.println(answer == result);
    }
}

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. HashMap을 만든다
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 1);
        }

        // 2. 모든 전화번호의 접두어가 HashMap 에 있는지 확인한다.
        for (String phoneNumber : phone_book) {
            for (int i = 0; i < phoneNumber.length(); i++) {
                if (map.containsKey(phoneNumber.substring(0, i))) {
                    return false;
                }
            }
        }

        // 3. 여기까지 왔다면 접두어가 없다는 것이다.
        return true;
    }
}

class FailSolution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 1. 전화번호 길이별로 HashMap 에 저장
        HashMap<Integer, List<String>> phoneMap = new HashMap<>();
        for (String phoneNumber : phone_book) {
            int phoneNumberLength = phoneNumber.length();
//            phoneMap.put(phoneNumberLength, phoneMap.getOrDefault(phoneNumberLength, new ArrayList<>()));
            List<String> phoneNumberList;
            if (phoneMap.get(phoneNumberLength) == null) {
                phoneNumberList = new ArrayList<>();
                phoneMap.put(phoneNumberLength, phoneNumberList);
            } else {
                phoneNumberList = phoneMap.get(phoneNumberLength);
            }
            phoneNumberList.add(phoneNumber);
        }
//        System.out.println("phoneMap = " + phoneMap);

        // 2. HashMap 의 Value 정렬
        for (List<String> phoneNumbers : phoneMap.values()) {
            Collections.sort(phoneNumbers);
        }

//        System.out.println("phoneMap = " + phoneMap);

        // 3. HashMap 을 돌면서 접두사가 되는 부분 탐색
        // 3.1 현재 기준이 되는 key 보다 큰 key 만 탐색.
        // 3.2 비교하는 value 보다 현재 기준이 되는 value 가 클 경우 다음 기준 확인
        Arrays.asList(phoneMap.keySet());

        return answer;
    }
}