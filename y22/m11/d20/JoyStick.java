package m11.d20;

public class JoyStick {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int count = solution.solution("JAZ");
//        System.out.println(count == 11);

        int count = solution.solution("JEROEN");
        System.out.println(count == 56);

    }
}

class Solution {
    public int solution(String name) {
        int count = 0;
        int length = name.length();
        int move = length - 1;

        for (int i = 0; i < name.length(); i++) {
            // 상하
            count += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));

            // 좌우
            int index = i + 1; // 다음에 탐색할 A가 아닌 인덱스
            while (index < name.length() && name.charAt(index) == 'A') {
                index++;
            }

            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, i + (length - index) * 2);
        }
        return count + move;
    }
}

class CorrectSolution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index; // 다음 값들을 확인할 때 사용
        int move = length - 1; // 좌우 움직임 수를 체크

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            // 연속되는 A 갯수 확인
            while (index < length && name.charAt(index) == 'A') {
                index++;
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i * 2 + length - index);
            // 2022년 이전 테스트 케이스만 확인하면 여기까지해도 정답처리가 되기 때문에, 이전 정답들에는 여기까지만 정리되어 있지만,
            // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
            move = Math.min(move, (length - index) * 2 + i);
        }
        return answer + move;
    }
}