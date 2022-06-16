package y22.m06.d16;

import java.util.*;
import java.util.stream.Collectors;

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

// 합계: 100 / 100.0
class Solution {
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

// 클래스를 만들어 풀었지만 훨씬 더 간결
class Solution1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        HashMap<String, Integer> suspendedList = new HashMap<>(); //<이름>
        HashMap<String, Integer> idIdx = new HashMap<String, Integer>(); // <이름, 해당 이름의 User 클래스 idx>
        int idx = 0;

        for (String name : id_list) {
            idIdx.put(name, idx++);
            users.add(new User(name));
        }

        for (String re : report) {
            String[] str = re.split(" ");
            users.get(idIdx.get(str[0])).reportList.add(str[1]);
            users.get(idIdx.get(str[1])).reportedList.add(str[0]);
        }

        for (User user : users) {
            if (user.reportedList.size() >= k) suspendedList.put(user.name, 1);
        }

        for (User user : users) {
            for (String nameReport : user.reportList) {
                if (suspendedList.get(nameReport) != null) {
                    answer[idIdx.get(user.name)]++;
                }

            }
        }


        return answer;
    }
}

class User {
    String name;
    HashSet<String> reportList;
    HashSet<String> reportedList;

    public User(String name) {
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}

// 진짜 깔끔, Steam 봐야 겠다.
class Solution2 {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}