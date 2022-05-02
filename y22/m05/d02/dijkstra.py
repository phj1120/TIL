import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())
start = int(input())

graph = [[] for i in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))  # 노드 a 에서 노드 b 로 가는데 필요한 비용 c


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    while q:
        dist, now = heapq.heappop(q)  # 노드 start 에서 노드 now 까지의 거리 dist, 거리가 짧은 순서로 pop
        if dist > distance[now]:
            continue
        for i in graph[now]:  # 노드 now 에서 갈 수 있는 인근 노드 i
            cost = dist + i[1]  # 노드 now 를 거쳐 노드 i 로 갈 경우의 거리
            if cost < distance[i[0]]:  # 노드 now 를 거쳐 갈 경우의 거리가 더 짧은 경우
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))  # 힙 q 에 거리, 노드 삽입


dijkstra(start)
print(distance)
