package y22.m09.d03;

import java.util.*;

public class ReportResult {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] correctResult = {2, 1, 1, 0};
        int[] answer = solution.solution(id_list, report, k);
        System.out.println(Arrays.equals(answer, correctResult));
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고 결과 종합
        Map<String, Set<String>> reportMap = new LinkedHashMap<>();

        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
        }
        System.out.println("reportMap = " + reportMap);

        for (String reportString : report) {
            String[] data = reportString.split(" ");
            String reporter = data[0];
            String target = data[1];
            Set<String> reportSet = reportMap.get(target);
            reportSet.add(reporter);
        }
        System.out.println("reportMap = " + reportMap);

        // k번 이상 신고 받은 사용자 이용 정지 및 신고한 사용자에게 이메일 전송

        Map<String, Integer> receiveEmailMap = new LinkedHashMap<>();

        for (String id : id_list) {
            receiveEmailMap.put(id, 0);
        }

        for (Set<String> reporterSet : reportMap.values()) {
            if (reporterSet.size() >= k) {
                for (String reporter : reporterSet) {
                    Integer receiveCount = receiveEmailMap.get(reporter);
                    receiveEmailMap.put(reporter, receiveCount + 1);
                }
            }
        }

        // 각 사용자가 이메일 받은 횟수 반환
        System.out.println("receiveEmailMap = " + receiveEmailMap);
        int[] answer = new int[id_list.length];
        int i = 0;
        for (int receiveCount : receiveEmailMap.values()) {
            answer[i] = receiveCount;
            i++;
        }
        return answer;
    }
}