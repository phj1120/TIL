package y22.m09.d02;

import java.util.*;

public class RankSearch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] correctResult = {1, 1, 1, 1, 2, 4};
        int[] answer = solution.solution(info, query);

//        System.out.println(correctResult.equals(answer));
        System.out.println(Arrays.equals(correctResult, answer));
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
                            String[] keyData = {l, fi, c, fo};
                            String key = String.join(" ", keyData);
//                            String key = l + " " + fi + " " + c + " " + fo;
                            List<Integer> list = infoMap.getOrDefault(key, new ArrayList<>());
                            list.add(score);
                            infoMap.put(key, list);
                        }
                    }
                }
            }
        }

        // 2. 지원자의 정보를 오름차순으로 정렬한다.
        for (List<Integer> arr : infoMap.values()) {
            arr.sort(null);
        }

        // 3. 조건에 맞는 사용자 수를 배열에 담는다.
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String condition = query[i];
            condition = condition.replaceAll(" and ", " ");
            String[] data = condition.split(" ");
            int passScore = Integer.parseInt(data[4]);
            String key = data[0] + " " + data[1] + " " + data[2] + " " + data[3];

            if (infoMap.containsKey(key)) {
                List<Integer> list = infoMap.get(key);
                // 4. lower-bound/하한선 찾기
                int left = 0;
                int right = list.size();
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= passScore)
                        right = mid;
                    else
                        left = mid + 1;
                }
                result[i] = list.size() - left;
            }
        }
        return result;
    }
}

class BestSolution {
    public int[] solution(String[] info, String[] query) {
        // 1. info를 기반으로 hashMap 만들기
        HashMap<String, ArrayList<Integer>> hashMap = new HashMap<>();

        for (String i : info) {
            String[] data = i.split(" ");
            String[] languages = { data[0], "-" };
            String[] jobs = { data[1], "-" };
            String[] exps = { data[2], "-" };
            String[] foods = { data[3], "-" };
            Integer value = Integer.parseInt(data[4]);
            for (String lang : languages)
                for (String job : jobs)
                    for (String exp : exps)
                        for (String food : foods) {
                            String[] keyData = { lang, job, exp, food };
                            String key = String.join(" ", keyData);
                            ArrayList<Integer> arr = hashMap.getOrDefault(key, new ArrayList<Integer>());

                            arr.add(value);
                            hashMap.put(key, arr);
                        }
        }

        // 2. 각 hashMap의 value를 오름차순 정렬하기
        for (ArrayList<Integer> scoreList : hashMap.values())
            scoreList.sort(null);

        // 3. query 조건에 맞는 지원자를 가져오기
        int[] answer = new int[query.length];
        int i = 0;
        for (String q : query) {
            String[] data = q.split(" and ");
            int target = Integer.parseInt(data[3].split(" ")[1]);
            data[3] = data[3].split(" ")[0];
            String key = String.join(" ", data);

            if (hashMap.containsKey(key)) {
                ArrayList<Integer> list = hashMap.get(key);
                // 4. lower-bound/하한선 찾기
                int left = 0;
                int right = list.size();
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) >= target)
                        right = mid;
                    else
                        left = mid + 1;
                }

                answer[i] = list.size() - left;
            }
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50" };
        String[] query = { "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
        System.out.println(sol.solution(info, query));
    }
}
