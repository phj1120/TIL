def solution(citations):
    citations.sort(reverse=True)

    idx = 0
    h_index = 0
    while len(citations) > idx:
        citation = citations[idx]
        same_number_max_idx = get_same_number_max_idx(citations, citation)
        print(citations, citation, same_number_max_idx)
        if same_number_max_idx + 1 >= citation:
            if sum(citations[same_number_max_idx + 1:]) <= citation:
                h_index = citation
                break
        idx = same_number_max_idx + 1
    return h_index


def get_same_number_max_idx(citations, citation):
    status = False
    for i, c in enumerate(citations):
        if c == citation:
            status = True
        elif status:
            return i - 1
    return len(citations) - 1
