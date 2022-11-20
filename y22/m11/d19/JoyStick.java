package m11.d19;

public class JoyStick {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int count = solution.solution("JAZ");
        System.out.println(count == 11);

    }
}

class Solution {
    public int solution(String name) {
//        String nowName = "";
//        for (char c : name.toCharArray()) {
//            nowName += "A";
//        }

        StringBuilder nowName = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            nowName.append('A');
        }

        int count = 0, index = 0;
        while (!name.equals(nowName.toString())) {
            int newIndex = getInRange(index, name.length());
            int changeCount = changeAlphabet(nowName.charAt(newIndex), name.charAt(newIndex));
            count += changeCount;
            nowName.setCharAt(index, name.charAt(newIndex));

            int move = nextMove(index, name);
            count += Math.abs(move);
            index += move;

        }

        return count;
    }

    private int nextMove(int index, String name) {
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(index + i) != 'A') {
                return index + 1;
            }

            if (name.charAt(index - i) != 'A') {
                return index - 1;
            }
        }
        return 0;
    }

    private int changeAlphabet(char now, char target) {
        return Math.min(target - now, 26 - (target - now));
    }

    private int getInRange(int index, int length) {
        // 인덱스가 음수 일 경우
        if (index < 0) {
            return length - (Math.abs(index) % length);
        }
        // 인덱스가 길이보다 크면
        if (index >= length) {
            return index % length;
        }
        return index;
    }

}
