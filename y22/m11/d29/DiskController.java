package m11.d29;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int correctAnswer = 9;
        int answer = solution.solution(jobs);
        System.out.println(correctAnswer == answer);
        System.out.println(answer);
    }
}

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시간 기준의 우선 순위 큐 생성
        PriorityQueue<Process> requestTimes = new PriorityQueue<>((p1, p2) -> p1.requestTime - p2.requestTime);
        for (int[] data : jobs) {
            requestTimes.add(new Process(data[0], data[1]));
        }
        List<Process> processes = new ArrayList<>(requestTimes);

        // 수행 시간 기준의 우선 순위 큐 생성
        PriorityQueue<Process> playTimes = new PriorityQueue<>((p1, p2) -> p1.playTime - p2.playTime);

        // 탐색
        int time = 0;
        while (!requestTimes.isEmpty() || !playTimes.isEmpty()) {
            // 현재 처리 할 수 있는 프로세스 갱신
            while (!requestTimes.isEmpty() && requestTimes.peek().requestTime <= time) {
                playTimes.add(requestTimes.poll());
            }

            // 가장 빠르게 처리할 수 있는 프로세스 실행
            if (playTimes.isEmpty()) {
                time++;
                continue;
            }
            // 실행 시작 시간 추가
            Process now = playTimes.poll();
            now.setStartTime(time);
            time += now.playTime;
        }

        // 평균 계산
        return processes.stream().mapToInt(Process::getTotalTime).sum() / processes.size();
    }

    static class Process {
        private int requestTime;
        private int playTime;
        private int startTime;

        public Process(int requestTime, int playTime) {
            this.requestTime = requestTime;
            this.playTime = playTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getTotalTime() {
            int endTime = startTime + playTime;
            return endTime - requestTime;
        }
    }
}


