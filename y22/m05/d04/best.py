# 진짜 봐도 모르겠음

# 랜덤여신 , Yang Sang-Ho , - , david

def compress(text, tok_len):
    words = [text[i:i + tok_len] for i in range(0, len(text), tok_len)]
    res = []
    cur_word = words[0]
    cur_cnt = 1
    for a, b in zip(words, words[1:] + ['']):
        if a == b:
            cur_cnt += 1
        else:
            res.append([cur_word, cur_cnt])
            cur_word = b
            cur_cnt = 1
    return sum(len(word) + (len(str(cnt)) if cnt > 1 else 0) for word, cnt in res)


def solution(text):
    return min(compress(text, tok_len) for tok_len in list(range(1, int(len(text) / 2) + 1)) + [len(text)])


a = [
    "aabbaccc",
    "ababcdcdababcdcd",
    "abcabcdede",
    "abcabcabcabcdededededede",
    "xababcdcdababcdcd",

    'aaaaaa',
]

for x in a:
    print(solution(x))

## 나른해
def compress(s,length):
    target,s,cnt = s[:length], s[length:],1
    answer = ''
    while s:
        if target==s[:length]:
            s,cnt = s[length:], cnt+1
        else:
            answer+=str(cnt)+target if cnt>1 else target
            target,s,cnt = s[:length], s[length:], 1
    return len(answer+str(cnt)+target if cnt>1 else answer+target)
def solution(s):
    answer = len(s)
    for i in range(1,len(s)+1):
        answer = min(answer,compress(s,i))
    return answer