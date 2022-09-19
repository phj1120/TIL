package y22.m09.d20;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Job> leftJobs = new PriorityQueue<>((j1, j2) -> {
            return j1.getRequestTime() - j2.getRequestTime();
        });
        PriorityQueue<Job> ableJobs = new PriorityQueue<>((j1, j2) -> {
            return j1.getWorkTime() - j2.getWorkTime();
        });

        for (int[] data : jobs) {
            leftJobs.add(new Job(data[0], data[1]));
        }

        int time = 0;
        Job nowJob = null;
        while (true) {
            if (ableJobs.isEmpty() && leftJobs.isEmpty()) {
                break;
            }

            // 현재 시간 이후로 실행 가능한 Job 갱신
            while (!leftJobs.isEmpty()) {
                Job job = leftJobs.peek();
                if (job.getRequestTime() <= time) {
                    ableJobs.add(job);
                    leftJobs.poll();
                } else {
                    break;
                }
            }

            // 가능한 다음 작업 시작
            if (!ableJobs.isEmpty()) {
                nowJob = ableJobs.poll();
                nowJob.start(time);
                answer += nowJob.getPlayTime();
                // 끝난 시간으로 이동
                time = nowJob.getEndTime();
            }else{
                time ++;
            }
        }
        return answer / jobs.length;
    }
}

class Job {
    private int requestTime;
    private int workTime;
    private int startTime;
    private int endTime;
    private int playTime;

    public int getRequestTime() {
        return requestTime;
    }

    public int getWorkTime() {
        return workTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getPlayTime() {
        return playTime;
    }

    public Job(int requestTime, int workTime) {
        this.requestTime = requestTime;
        this.workTime = workTime;
    }

    public void start(int startTime) {
        this.startTime = startTime;
        this.endTime = startTime + this.getWorkTime();
        this.playTime = endTime - requestTime;
    }
}

public class Disk {
    public static void main(String[] args) {

        Solution solution = new Solution();
//        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
//        int correctResult = 9;
//        int answer = solution.solution(jobs);
//        System.out.println(answer == correctResult);
//        System.out.println(answer);
//
        int[][] jobs = {{7, 8}, {3, 5}, {8, 6}};
        int correctResult = 9;
        int answer = solution.solution(jobs);
        System.out.println(answer == correctResult);
        System.out.println(answer);
    }

}

