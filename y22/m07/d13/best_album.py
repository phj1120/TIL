## 실패
def solution(genres, plays):
    answer = []
    genres_play_count = {genre: 0 for genre in genres}
    for i in range(len(genres)):
        genre = genres[i]
        play = plays[i]
        genres_play_count[genre] += play

    while genres_play_count:
        max_key = max(genres_play_count, key=genres_play_count.get)
        genres_play_count.pop(max_key)
        # 장르별 가장 많이 들은 2곡 저장 하는 코드

    return answer


## 다른 사람 코드
def solution(genres, plays):
    answer = []

    dic1 = {}
    dic2 = {}

    for i, (g, p) in enumerate(zip(genres, plays)):
        if g not in dic1:
            dic1[g] = [(i, p)]
        else:
            dic1[g].append((i, p))

        if g not in dic2:
            dic2[g] = p
        else:
            dic2[g] += p

    for (k, v) in sorted(dic2.items(), key=lambda x: x[1], reverse=True):
        for (i, p) in sorted(dic1[k], key=lambda x: x[1], reverse=True)[:2]:
            answer.append(i)

    return answer
