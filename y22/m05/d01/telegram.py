import sys
import heapq

input = sys.stdin.readline
INF = int(1e9)
# 도시의 개수, 통로의 개수, 시작점
n, m, c = map(int, input().split())

graph = [[] for i in range(m + 1)]
distance = [INF] * (n + 1)
visited = [False] * (n + 1)

for _ in range(m):
    # 출발 노드, 도착 노드, 거리
    x, y, z = map(int, input().split())

    # 출발 노드, 거리, 도착 노드
    graph[x].append((z, y))
    

q = []
heapq.heappush(q, (c, 0))
while q:
    # 거리, 현재 노드 번호
    dist, now = heapq.heappop(q)
    if visited[now]:
        continue
    visited[now] = True



    for node in graph[now]:
        heapq.heappush(q, node)







