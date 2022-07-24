def solution(tickets):
    def init_graph():
        routes = {}
        for key, value in tickets:
            if not routes.get(key):
                routes[key] = [value]
            else:
                routes[key].append(value)
        for r in routes:
            routes[r].sort()
        return routes

    def has_not_ticket(routes, top):
        return top not in routes or not routes[top]

    def dfs():
        stack = ["ICN"]
        path = []
        while stack:
            top = stack[-1]
            if has_not_ticket(routes, top):
                path.append(stack.pop())
            else:
                stack.append(routes[top].pop(0))
        path.reverse()
        return path

    routes = init_graph()
    answer = dfs()

    return answer


tickets = [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
correct_answer = ["ICN", "JFK", "HND", "IAD"]

tickets = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL", "SFO"]]
correct_answer = ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]

tickets = [["ICN", "AAA"], ["ICN", "BBB"], ["BBB", "ICN"]]
correct_answer = ["ICN", "BBB", "ICN", "AAA"]

print(correct_answer == solution(tickets))
