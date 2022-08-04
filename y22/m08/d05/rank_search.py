def solution(info, query):
    answer = []
    applicants_tmp = []  # 지원자 정보
    conditions = {}  # 조건

    languages = ['cpp', 'java', 'python']
    jobs = ['backend', 'frontend']
    careers = ['junior', 'senior']
    foods = ['chicken', 'pizza']

    meet_the_requirements_cnts = []

    for l in languages:
        for j in jobs:
            for c in careers:
                for f in foods:
                    conditions[(l, j, c, f)] = []

    for applicant in info:
        language, job, career, food, score = applicant.split()
        conditions[(language, job, career, food)].append(int(score))

    for key in conditions:
        conditions[key].sort()

    for requirements in query:
        meet_the_requirements_cnt = 0
        requirement_language, requirement_job, requirement_career, requiring_more_action_string = requirements.split(' and ')
        requirement_food, requirement_score = requiring_more_action_string.split()

        if requirement_language == '-':
            requirement_languages = languages
        else:
            requirement_languages = [requirement_language]

        if requirement_job == '-':
            requirement_jobs = jobs
        else:
            requirement_jobs = [requirement_job]

        if requirement_career == '-':
            requirement_careers = careers
        else:
            requirement_careers = [requirement_career]

        if requirement_food == '-':
            requirement_foods = foods
        else:
            requirement_foods = [requirement_food]

        for l in requirement_languages:
            for j in requirement_jobs:
                for c in requirement_careers:
                    for f in requirement_foods:
                        scores = conditions[(l, j, c, f)]
                        if scores:
                            start, end = 0, len(scores)
                            while start != end and start != len(scores):
                                if scores[(start + end) // 2] >= int(requirement_score):
                                    end = (start + end) // 2
                                else:
                                    start = (start + end) // 2 + 1
                        if (len(scores) - start) > 0:
                            meet_the_requirements_cnt += (len(scores) - start)
        meet_the_requirements_cnts.append(meet_the_requirements_cnt)

    return meet_the_requirements_cnts
