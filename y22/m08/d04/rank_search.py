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
        conditions[(language, job, career, food)].append(score)

    for key in conditions:
        conditions[key].sort(reverse=True)

    for requirements in query:
        meet_the_requirements_cnt = 0
        requirement_language, requirement_job, requirement_career, requiring_more_action_string = requirements.split(' and ')
        requirement_food, requirement_score = requiring_more_action_string.split()
        # print('\n', requirement_language, requirement_job, requirement_career, requirement_food, requirement_score)

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
                        # print((l, j, c, f))
                        scores = conditions[(l, j, c, f)]
                        for idx, score in enumerate(scores):
                            # print(idx, score, requirement_score)
                            if score >= requirement_score:
                                # print(idx)
                                meet_the_requirements_cnt = idx+1
                            else:
                                break

        # print(meet_the_requirements_cnt)
        meet_the_requirements_cnts.append(meet_the_requirements_cnt)
        # print(requirement_languages, requirement_jobs, requirement_careers, requirement_foods)

    return meet_the_requirements_cnts