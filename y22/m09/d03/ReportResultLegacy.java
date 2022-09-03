package y22.m09.d03;

import java.util.*;

public class ReportResultLegacy {

    public static void main(String[] args) {

    }
}


class LegacySolution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // 사용자 신고 기록 객체가 담긴 리스트 생성
        HashMap<String, ReportLog> memberList = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            memberList.put(id_list[i], new ReportLog());
        }

        // 신고 기록 확인
        for (String reportLog : report) {
            String[] log = reportLog.split(" ");
            String singoja = log[0];
            String daesang = log[1];
            ReportLog singojaReport = memberList.get(singoja);
            ReportLog daesangReport = memberList.get(daesang);

            // 이미 신고한 사용자 일 경우 넘김
            if (daesangReport.wasReporter(singoja)) continue;

            // 신고 당한 사람
            daesangReport.addReportCount(); // 신고 회 수 증가
            daesangReport.addReporterId(singoja); // 신고한 사람 아이디 추가

            // 신고 한 사람
            singojaReport.addReportId(daesang); // 신고 완료 된 사람 아이디 추가

            // 정지 기준을 넘은 경우 내가 신고 해서 정지 된 사람 (SuspensionIds) 추가.
            if (daesangReport.getReportCount() == k) {
                for (String id : daesangReport.getReporterIds()) {
                    memberList.get(id).addSuspensionId(daesang);
                }
            } else if (daesangReport.getReportCount() > k) {
                singojaReport.addSuspensionId(daesang);
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

