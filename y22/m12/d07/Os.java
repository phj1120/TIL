package y22.m12.d07;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Os {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] program = {{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}};
        long[] correctAnswer = {20, 5, 0, 16, 0, 0, 0, 0, 0, 0, 0};
        long[] answer = solution.solution(program);
        System.out.println(Arrays.equals(correctAnswer, answer));
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public long[] solution(int[][] program) {
        long[] answer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        // 실행 시간 짧은 기준인 우선 순위큐에 작업 목록 담기
        PriorityQueue<Process> processesByRequestTime = new PriorityQueue<>(
                (p1, p2) -> p1.requestTime - p2.requestTime
        );
        for (int[] data : program) {
            processesByRequestTime.add(new Process(data[0], data[1], data[2]));
        }

        // 시간이 증가함에 따라 작업 실행
        PriorityQueue<Process> playableProcess = new PriorityQueue<>(
                (p1, p2) -> {
                    if (p1.rank == p2.rank) {
                        return p1.requestTime - p2.requestTime;
                    }
                    return p1.rank - p2.rank;
                }
        );

        long now = 0;
        while (!processesByRequestTime.isEmpty() || !playableProcess.isEmpty()) {
            // 현재 시간에 실행 가능한 작업 큐에 저장
            while (!processesByRequestTime.isEmpty() && processesByRequestTime.peek().requestTime <= now) {
                playableProcess.add(processesByRequestTime.poll());
            }

            // 실행할 수 있는 작업이 없으면
            if (playableProcess.isEmpty()) {
                now = processesByRequestTime.peek().requestTime;
                continue;
            }

            Process nowProcess = playableProcess.poll();
            nowProcess.setStartTime(now);
            answer[nowProcess.rank] += nowProcess.getWaitTime();
            now += nowProcess.playTime;
        }
        answer[0] = now;
        return answer;
    }
}

class Process implements Comparable<Process> {
    int rank;
    int requestTime;
    int playTime;
    long startTime;

    public Process(int rank, int requestTime, int playTime) {
        this.rank = rank;
        this.requestTime = requestTime;
        this.playTime = playTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getWaitTime() {
        return startTime - requestTime;
    }

    @Override
    public int compareTo(Process p) {
        if (p.rank == this.rank) {
            return this.requestTime - p.requestTime;
        }
        return this.rank - p.rank;
    }
}