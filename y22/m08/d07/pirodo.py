def first_solution(k, dungeons):
    from itertools import permutations

    routes = []
    for i in range(1, len(dungeons) + 1):
        for route in list(permutations(dungeons, i)):
            routes.append(route)

    max_clear = -1
    for route in routes:
        health = k
        clear = 0
        for dungeon in route:
            demand, consume = dungeon
            if health >= demand:
                clear += 1
                health -= consume
            else:
                break
            if max_clear < clear:
                max_clear = clear
    return max_clear


def best_solution(k, dungeons):
    from itertools import permutations

    max_clear = -1
    for route in permutations(dungeons, len(dungeons)):
        health = k
        clear = 0
        for dungeon in route:
            demand, consume = dungeon
            if health >= demand:
                clear += 1
                health -= consume
            else:
                break
            if max_clear < clear:
                max_clear = clear
    return max_clear

