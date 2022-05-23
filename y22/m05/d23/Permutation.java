package y22.m05.d23;

public class Permutation {
    public static void main(String[] args) throws InterruptedException {
        long beforeTime = System.currentTimeMillis();

        Solution sol = new Solution();

        // 입력
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};
//        String[] data = {"M~C<2", "C~M>1"};

        // 출력
        int correctAnswer = 3648;
//        int correctAnswer = 0;

        // 테스트 실행
        int answer = sol.solution(n, data);

        // 결과 비교
        if (correctAnswer == answer) {
            System.out.println("테스트를 통과하였습니다.");
        } else {
            System.out.printf("실행한 결괏값 %s이(가) 기댓값 %s와(과) 다릅니다.\n", answer, correctAnswer);
        }

        long afterTime = System.currentTimeMillis();
        System.out.printf("실행 시간 : %.3f 초\n", (float) (afterTime - beforeTime) / 1000);
    }
}

class Solution {
    static int cnt = 0;

    public int solution(int n, String[] data) {
        cnt = 0; // 해당 문제 채점시 테스트 코드를 한 번에 돌리는 듯. 전역 변수를 썼으므로 초기화 해줘야함
        char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        permutation(arr, 0, data);
        return cnt;
    }

    static void permutation(char[] arr, int depth, String[] data) {
        if (depth == arr.length) {
            for (int i = 0; i < data.length; i++) {
                String str = data[i]; // 조건
                String arrStr = new String(arr); // 정렬
                int idxA = arrStr.indexOf(str.charAt(0)), idxB = arrStr.indexOf(str.charAt(2));
                char op = str.charAt(3);
                int wantDistance = str.charAt(4) - '0';
                int realDistance = Math.abs(idxA - idxB) - 1;

                if (op == '=' && wantDistance != realDistance) break;
                else if (op == '>' && wantDistance >= realDistance) break;
                else if (op == '<' && wantDistance <= realDistance) break;

                if (i == data.length - 1) {
                    cnt++;
                }
            }
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, data);
            swap(arr, depth, i);
        }
    }

    static void swap(char[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}