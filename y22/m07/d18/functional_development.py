def solution(progresses, speeds):
    import math

    distribute_count = []
    complete_days = []
    for i in range(len(progresses)):
        complete_days.append(math.ceil((100 - progresses[i]) / speeds[i]))
    complete_days.reverse()

    day = 0

    while complete_days:
        day = complete_days.pop()
        complete_job_count = 1
        index = len(complete_days) - 1
        while complete_days:
            if index < len(complete_days) and day >= complete_days[index]:
                complete_days.pop()
                complete_job_count += 1
                index -= 1
            else:
                break
        distribute_count.append(complete_job_count)
    return distribute_count


def second_solution(progresses, speeds):
    import math

    distribute_count = []
    complete_days = []
    for i in range(len(progresses)):
        complete_days.append(math.ceil((100 - progresses[i]) / speeds[i]))

    while complete_days:
        day = complete_days.pop(0)
        complete_job_count = 1
        while complete_days:
            if day >= complete_days[0]:
                complete_days.pop(0)
                complete_job_count += 1
            else:
                break
        distribute_count.append(complete_job_count)
    return distribute_count


def other_solution(progresses, speeds):
    answer = []
    days = 0
    count = 0

    while progresses:
        if progresses[0] + days * speeds[0] >= 100:
            progresses.pop(0)
            speeds.pop(0)
            count += 1
        else:
            if count > 0:
                answer.append(count)
                count = 0
            days += 1

    answer.append(count)

    return answer
