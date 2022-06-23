def solution(cacheSize, cities):
    run_time = 0
    cache = []

    if cacheSize == 0:
        return len(cities) * 5

    for city in cities:
        city = city.lower()
        if city in cache:
            cache.remove(city)
            cache = [city] + cache
            run_time += 1
        else:
            if len(cache) == cacheSize:
                cache.remove(cache[-1])
            cache = [city] + cache
            run_time += 5

    return run_time


def best_solution(cacheSize, cities):
    import collections
    cache = collections.deque(maxlen=cacheSize)
    time = 0
    for i in cities:
        s = i.lower()
        if s in cache:
            cache.remove(s)
            cache.append(s)
            time += 1
        else:
            cache.append(s)
            time += 5
    return time
