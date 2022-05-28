package y22.m05.d28;

class MySol {
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
                String str = data[i]; // 입력 받은 조건
                String arrStr = new String(arr); // 정렬할 카카오 프렌즈 목록
                int idxA = arrStr.indexOf(str.charAt(0)); // 지정한 대상의 현재 위치 : A
                int idxB = arrStr.indexOf(str.charAt(2)); // 지정할 대상의 현재 위치 : B
                char op = str.charAt(3);
                int wantDistance = str.charAt(4) - '0';
                int realDistance = Math.abs(idxA - idxB) - 1;

                // 입력한 조건을 충족하지 못할 경우 다음 경우 탐색
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