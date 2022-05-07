import math


def solution(alp, cop, problems):
    pos_pbs, impos_pbs = posimpos(alp, cop, [], problems)

    while impos_pbs:
        # 다음 목표 선택
        for pos_pb in pos_pbs:
            for impos_pb in impos_pbs:
                impos_alp_req = impos_pb[0]
                impos_cop_req = impos_pb[1]
                impos_alp_rwd = impos_pb[2]
                impos_cop_rwd = impos_pb[3]
                impos_cost = impos_pb[4]

                print(pos_pb, impos_pb)
        impos_pbs = []

    answer = 0
    return answer


def posimpos(alp, cop, pos_pb, impos_pb):
    new_pos_pb = []
    new_impos_pb = []
    for pb in impos_pb:
        if pb[0] > alp or pb[1] > cop:
            new_impos_pb.append(pb)
        else:
            new_pos_pb.append(pb)

    return new_pos_pb, new_impos_pb




# 10	10	[[10,15,2,1,2],[20,20,3,3,4]]	15
# 0	0	[[0,0,2,1,2],[4,5,3,1,2],[4,11,4,0,2],[10,4,0,4,2]]	13

solution(0, 0, [[0, 0, 2, 1, 2], [4, 5, 3, 1, 2], [4, 11, 4, 0, 2], [10, 4, 0, 4, 2]])
