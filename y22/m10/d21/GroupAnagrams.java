package y22.m10.d21;

import java.util.*;

public class GroupAnagrams {
    //Runtime: 74 ms, faster than 10.39% of Java online submissions for Group Anagrams.
    //Memory Usage: 49.3 MB, less than 84.09% of Java online submissions for Group Anagrams.
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();
            for (String str : strs) {
                // 1. make anagram Map
                Map<Character, Integer> anagramMap = new HashMap<>();
                for (char ch : str.toCharArray()) {
                    anagramMap.put(ch, anagramMap.getOrDefault(ch, 0) + 1);
                }
                // 2. check exist
                if (!groups.containsKey(anagramMap)) {
                    groups.put(anagramMap, new ArrayList<String>());
                }
                List<String> anagramList = groups.get(anagramMap);
                anagramList.add(str);
            }

            List<List<String>> answer = new ArrayList<>();
            for (List<String> list : groups.values()) {
                answer.add(list);
            }

            return answer;
        }
    }

    //Runtime: 16 ms, faster than 42.48% of Java online submissions for Group Anagrams.
    //Memory Usage: 57.4 MB, less than 25.95% of Java online submissions for Group Anagrams.
    class OtherSolution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            if (strs.length == 0) return res;
            HashMap<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] hash = new char[26];
                for (char c : s.toCharArray()) {
                    hash[c - 'a']++;
                }
                String key = new String(hash);
                map.computeIfAbsent(key, k -> new ArrayList<>());
                map.get(key).add(s);
            }
            res.addAll(map.values());
            return res;
        }
    }

    // 비슷한 코드여도 사용 메모리랑, 실행 시간 왔다 갔다 함.
    class OtherSolution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new ArrayList<>();
            if (strs.length == 0) return res;
            HashMap<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] hash = new char[26];
                for (char c : s.toCharArray()) {
                    hash[c - 'a']++;
                }
                String key = new String(hash);

                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<String>());
                }
                List<String> anagramList = map.get(key);
                anagramList.add(s);
            }
            res.addAll(map.values());
            return res;
        }
    }
}

