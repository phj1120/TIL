package y22.m05.d28;

public class Permutation {
    public static void main(String[] args) throws InterruptedException {
        long beforeTime = System.currentTimeMillis();

        MySol sol = new MySol();
//        BestSol sol = new BestSol();
//        FastSol sol = new FastSol();

        System.out.println("\"fasfs\".split(1, \"fasfs\".length()) = " + "fasfs".substring(1));

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
