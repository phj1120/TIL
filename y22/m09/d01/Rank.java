package y22.m09.d01;

import java.util.*;

public class Rank {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] result = {1, 1, 1, 1, 2, 4};

        int[] answer = solution.solution(info, query);
        System.out.println(result.equals(info));
    }

}

class Solution {
    public int[] solution(String[] info, String[] query) {
        // 1. 지원자의 정보를 Map 에 저장한다.
        Map<String, List<Integer>> infoMap = new HashMap<>();
        for (String applicant : info) {
            String[] data = applicant.split(" ");
            String[] language = {data[0], "-"};
            String[] field = {data[1], "-"};
            String[] career = {data[2], "-"};
            String[] food = {data[3], "-"};
            int score = Integer.parseInt(data[4]);

            for (String l : language) {
                for (String fi : field) {
                    for (String c : career) {
                        for (String fo : food) {
                            String key = l + " " + fi + " " + c + " " + fo;
                            if (infoMap.get(key) == null) {
                                List<Integer> initList = new ArrayList<>();
                                initList.add(score);
                                infoMap.put(key, initList);
                            } else {
                                List<Integer> list = infoMap.get(key);
                                list.add(score);
                            }
                            // 주소를 넘겨주니까 put 을 안해줘도 되는거 아닌가? 처음에 put 을 안해주기 떄문 위의 코드로 해결
//                            List<Integer> list = infoMap.getOrDefault(key, new ArrayList<>());
//                            list.add(score);
//                            infoMap.put(key, list);
                        }
                    }
                }
            }
        }

        // 2. 조건에 맞는 사용자 수를 배열에 담는다.
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String condition = query[i];
            condition = condition.replaceAll(" and ", " ");
            String[] data = condition.split(" ");
            int passScore = Integer.parseInt(data[4]);
            String key = data[0] + " " + data[1] + " " + data[2] + " " + data[3];

            int count = (int) infoMap.get(key).stream()
                    .filter(score -> score >= passScore)
                    .count();
            result[i] = count;
        }
        return result;
    }
}