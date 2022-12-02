# 2022.12.02.

# 올바른 괄호

[올바른 괄호](https://school.programmers.co.kr/learn/courses/30/lessons/12909)

이걸 내가 진짜 오래 쓸 클래스, 나중에 다른 사람들과 협업할 코드라고 생각하고 작성해봤다.

우테코 프리코스 하면서 지향해야할 코드라 들은 depth 2단계 제한, else 문 사용하지 않기를 적용해 봤다.

근데 왜 else 문 사용을 자제하고 early return 을 해야할까?

결국 길어지면 goto 문 처럼 코드의 흐름을 방해하는 코드가 될 텐데?

일단은 지금 이 코드가 내 최선의 코드다.

예전에 작성했을 떄보다 깔끔해진 것이 확실하게 느껴진다. 다음에 또 작성해 봐야지.

* AS-IS

```
class PrevSolution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.size() > 0) {
            return false;
        }
        return true;
    }
}
```

* AS-IS

```
class Solution {
    boolean solution(String s) {
        Stack<Character> brackets = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (bracket != '(' && bracket != ')') {
                throw new RuntimeException();
            }
            if ('(' == bracket) {
                brackets.add('(');
                continue;
            }
            if (brackets.isEmpty()) {
                return false;
            }
            brackets.pop();
        }
        return brackets.isEmpty();
    }
}
```

* TO-BE

```
class Solution {
    char OPEN_BRACKET = '(';
    char CLOSE_BRACKET = ')';

    boolean solution(String s) {
        Stack<Character> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char bracket = validBracket(s.charAt(i));

            if (bracket == OPEN_BRACKET) {
                brackets.add(bracket);
                continue;
            }

            if (brackets.isEmpty()) {
                return false;
            }

            brackets.pop();
        }
        return brackets.isEmpty();
    }

    private char validBracket(char character) {
        if (isOtherCharacter(character)) {
            throw new RuntimeException();
        }
        return character;
    }

    private boolean isOtherCharacter(char bracket) {
        return bracket != OPEN_BRACKET && bracket != CLOSE_BRACKET;
    }
}

```