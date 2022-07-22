def solution(tickets):
    answer = []
    tickets.sort()
    q = ['ICN']
    is_used_tickets = [False for i in range(len(tickets))]

    while q:
        departures = q.pop(0)
        arrival = get_arrival(tickets, departures)
        print([departures, arrival])

    return answer


def get_next_ticket_index(tickets, departures):
    for idx, ticket in enumerate(tickets):
        if ticket[0] == departures:
            return idx


def get_arrival(tickets, departures):
    for idx, ticket in enumerate(tickets):
        if ticket[0] == departures:
            return ticket[1]
