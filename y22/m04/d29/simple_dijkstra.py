import sys

input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())
start = int(input())

graph = [[] for i in range(n + 1)]
visited = [False] * (n + 1)
distance = [INF] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))


def get_smallest_node():
    min_value = INF
    idx = 0
    for i in range(1, n +1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            idx = i
            # min_value = min(min_value, distance[i])

    return idx

def dijkstra(start):
    # 출발
    distance[start] = 0
    visited[start] = True
    for j in graph[start]:
        distance[j[0]] = j[1]

    # 반복
    for j in range(n - 1):  # j[0] : 번호, j[1] : 거리
        now = get_smallest_node()
        visited[now] = True
        for j in graph[now]:
            distance[j[0]] = min(distance[j[0]], distance[now] + j[1])


dijkstra(start)
print(distance)

'''
[1000000000, 0, 2, 3, 1, 2, 4]
'''