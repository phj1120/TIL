import sys

input = sys.stdin.readline
INF = int(1e9)  # 무한

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
    index = 0
    for i in range(1, n + 1):
        if distance[i] < min_value and not visited[i]:
            min_value = distance[i]
            index = i
    return index


def dijkstra(start):
    distance[start] = 0  # 출발 노드 설정
    visited[start] = True  # 방문 처리
    # graph : [[], [(2, 2), (3, 5), (4, 1)], [(3, 3), (4, 2)], [(2, 3), (6, 5)], [(3, 3), (5, 1)], [(3, 1), (6, 2)], []]
    for j in graph[start]:  # 출발 노드에서 갈 수 있는 노드들
        distance[j[0]] = j[1]  # 거리를 distance 에 저장 j[0] : 번호, j[1] : 거리

    for j in range(n - 1):
        now = get_smallest_node()  # 방문하지 않은 노드 중 거리가 가장 짧은 노드 선택 ( 해당 값은 고정 됨 )
        visited[now] = True  # 방문 처리
        for j in graph[now]:  # 출발 노드에서 갈 수 있는 노드들
            distance[j[0]] = min(distance[j[0]], distance[now] + j[1])
            # cost = distance[now] + j[1]  # 출발점에서 현재 노드까지의 거리와 현재 위치에서 해당 노드 까지의 거리의 합
            # if cost < distance[j[0]]:  # 위의 값이 저장되어 있는 값보다 작을 경우
            #     distance[j[0]] = cost


dijkstra(start)

for i in range(1, n + 1):
    if distance[i] == INF:
        print("INFINITY")
    else:
        print(distance[i])

'''

6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2

'''
