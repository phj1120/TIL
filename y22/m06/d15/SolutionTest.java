package y22.m06.d15;

import java.util.*;

public class SolutionTest {
    public static void main(String[] args) throws InterruptedException {
        long beforeTime = System.currentTimeMillis();

        Solution sol = new Solution();

        // 입력
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};

        int k = 2;

        // 출력
        int[] correctAnswer = {2, 1, 1, 0};

        // 테스트 실행
        int[] answer = sol.solution(id_list, report, k);

        String answerStr = Arrays.toString(answer);
        String correctAnswerStr = Arrays.toString(correctAnswer);

        // 결과 비교
        if (correctAnswerStr.equals(answerStr)) {
            System.out.println("테스트를 통과하였습니다.");
        } else {
            System.out.printf("실행한 결괏값 %s이(가) 기댓값 %s와(과) 다릅니다.\n", answerStr, correctAnswerStr);
        }

        long afterTime = System.currentTimeMillis();
        System.out.printf("실행 시간 : %.3f 초\n", (float) (afterTime - beforeTime) / 1000);
    }
}

// 합계: 20.8 / 100.0
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, ReportLog> memberList = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            memberList.put(id_list[i], new ReportLog());
        }

        for (String reportLog : report) {
            String[] log = reportLog.split(" ");
            String singoja = log[0];
            String daesang = log[1];
            ReportLog singojaReport = memberList.get(singoja);
            ReportLog daesangReport = memberList.get(daesang);

            // 이미 신고한 경우
            if (daesangReport.wasReporter(singoja)) continue;

            // 신고
            daesangReport.addReportCount();
            daesangReport.addReporterId(singoja);
            singojaReport.addReportId(daesang);

            // 정지 기준을 넘은 경우 내가 신고 해서 정지 된 사람 추가.
            if (daesangReport.getReportCount() >= k) {
                for (String id : daesangReport.getReporterIds()) {

                    memberList.get(id).addSuspensionId(daesang);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            ReportLog log = memberList.get(id_list[i]);
            answer[i] = log.suspensionIds.size();
        }

        return answer;
    }
}

class ReportLog {
    List<String> reportIds = new ArrayList<>(); // 내가 신고한 사람 아이디
    List<String> suspensionIds = new ArrayList<>(); // 내가 신고 해서 정지 당한 사람 아이디
    List<String> reporterIds = new ArrayList<>(); // 나를 신고한 사람 아이디
    int reportCount; // 신고 당한 회수

    public void addReportCount() {
        this.reportCount++;
    }

    public int getReportCount() {
        return this.reportCount;
    }

    public void addReportId(String reportId) {
        this.reportIds.add(reportId);
    }

    public void addSuspensionId(String suspensionId) {
        this.suspensionIds.add(suspensionId);
    }

    public boolean wasReporter(String id) {
        for (String reporterId : reporterIds) {
            if (reporterId.equals(id)) return true;
        }
        return false;
    }

    public void addReporterId(String reporterId) {
        this.reporterIds.add(reporterId);
    }

    public List<String> getReporterIds() {
        return this.reporterIds;
    }

}