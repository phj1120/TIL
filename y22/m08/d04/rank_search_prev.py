def solution(info, query):
    answer = []
    applicants_tmp = []  # 지원자 정보 저장
    conditions = []  # 조건

    for str in info:
        applicants_tmp.append(str.split(' '))

    for str in query:
        applicants = applicants_tmp[:] # 리스트 얕은 복사
        str = str.replace(' and ', ' ')
        lang_condition, job_condition, career_condition, food_condition, score_condition = str.split(' ')
        conditions.append(str.split(' '))

        for applicant in applicants_tmp:
            lang_applicant, job_applicant, career_applicant, food_applicant, score_applicant = applicant

            if lang_condition != '-' and lang_condition != lang_applicant:
                applicants.remove(applicant)
                continue

            if job_condition != '-' and job_condition != job_applicant:
                applicants.remove(applicant)
                continue

            if career_condition != '-' and career_condition != career_applicant:
                applicants.remove(applicant)
                continue

            if food_condition != '-' and food_condition != food_applicant:
                applicants.remove(applicant)
                continue

            if int(score_condition) > int(score_applicant):
                applicants.remove(applicant)
                continue

        answer.append(len(applicants))
    return answer