labels = ['GE 491.508 ㅊ 638 ㅅ v.1 c.2']

'''
별치 기호 : se_shelf_code / GE
분류 기호 : class_no / 491.508
도서 기호 : book_code_head / ㅊ 
          book_code_body / 638
          book_code_tail / ㅅ
권책 기호 : version_code / v.1
          copy_code / c.2
'''


def is_start_consonant(string):
    return 'ㄱ' <= string[0] <= 'ㅎ'


def is_correct_sort(left, right):
    return left <= right


def extract_first_consonant(word):
    CHOSUNG_LIST = ['ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ']
    idx = (ord(word[0]) - ord('가')) // 588
    return CHOSUNG_LIST[idx]


class Label:
    def __init__(self, se_shelf_code, class_no, book_code_head, book_code_body,
                 book_code_tail, version_code=None, copy_code=None) -> None:
        self.se_shelf_code = se_shelf_code
        self.class_no = class_no
        self.book_code_head = book_code_head
        self.book_code_body = book_code_body
        self.book_code_tail = book_code_tail
        self.version_code = version_code
        self.copy_code = copy_code

    def __str__(self) -> str:
        return f'se_shelf_code : {self.se_shelf_code}, class_no : {self.class_no}, ' \
               f'book_code_head : {self.book_code_head}, book_code_body : {self.book_code_body},' \
               f'book_code_tail : {self.book_code_tail}, version_code : {self.version_code}, ' \
               f'copy_code : {self.copy_code}'

    # GE, YG
    def is_same_se_shelf_code(self, other_se_shelf_code):
        return self.se_shelf_code == other_se_shelf_code

    # 정수(필수), 소수점(선택)
    def is_correct_sort_class_no(self, next_class_no):
        return is_correct_sort(self.class_no, next_class_no)

    # 자음
    def is_correct_sort_book_code_head(self, next_book_code_head):
        return is_correct_sort(self.book_code_head, next_book_code_head)

    # 정수(필수), 소수점(선택)
    def is_correct_sort_book_code_body(self, next_book_code_body):
        return is_correct_sort(self.book_code_body, next_book_code_body)

    # 자음, 문자
    def is_correct_sort_book_code_tail(self, next_book_code_tail):
        """
        TODO 고민
        코딩 습관 - else if 를 줄여야 한다.
        일단 elif 를 안쓰기 위한 방법으로
        중간 마다 return 하고 순서에 의존 하는 if 문을 짰는데 오히려 안 좋은 코드인가? 라는 생각이 듬
        -> 일단 짜고 리팩터링 / 코딩 습관 - return 은 한 곳에서 만 하는 것도 고려
        """
        # 둘 다 자음인 경우
        if is_start_consonant(self.book_code_tail) and is_start_consonant(next_book_code_tail):
            return is_correct_sort(self.book_code_tail, next_book_code_tail)

        # 왼쪽 만 자음인 경우
        if is_start_consonant(self.book_code_tail):
            next_start_consonant = extract_first_consonant(next_book_code_tail)
            if self.book_code_tail == next_start_consonant:
                return False
            return is_correct_sort(self.book_code_tail, next_start_consonant)

        # 오른쪽 만 자음인 경우
        if is_start_consonant(next_book_code_tail):
            prevent_start_consonant = extract_first_consonant(self.book_code_tail)
            if prevent_start_consonant == next_book_code_tail:
                return False
            return is_correct_sort(prevent_start_consonant, next_book_code_tail)

        # 둘 다 단어인 경우
        return is_correct_sort(self.book_code_tail, next_book_code_tail)

    # v
    def is_correct_sort_version_code(self, next_version_code):
        if self.version_code is None:
            return True
        if next_version_code is None:
            return False
        return is_correct_sort(self.version_code, next_version_code)

    # c
    def is_correct_sort_copy_code(self, next_copy_code):
        if self.copy_code is None:
            return True
        if next_copy_code is None:
            return False
        return is_correct_sort(self.copy_code, next_copy_code)

    def is_correct_sort(self, next_label):
        # TODO is_correct_sort_book_code_tail 구현 후 차례로 순서 확인 하는 함수 제작
        pass


left_label = 'GE 491.508 ㅊ 638 ㄱ v.1 c.2'
left_se_shelf_code, left_class_no, left_book_code_head, left_book_code_body, left_book_code_tail, left_version_code, left_copy_code = left_label.split(' ')
left_label = Label(left_se_shelf_code, left_class_no, left_book_code_head, left_book_code_body, left_book_code_tail, left_version_code, left_copy_code)
print(f'left label : {left_label}')

right_label = 'GE 493 ㅎ 82 핳'
right_se_shelf_code, right_class_no, right_book_code_head, right_book_code_body, right_book_code_tail = right_label.split(' ')
right_label = Label(right_se_shelf_code, right_class_no, right_book_code_head, right_book_code_body, right_book_code_tail)
print(f'right_label : {right_label}')

print('\nTest is_same_se_shelf_code')
print(left_label.is_same_se_shelf_code('GE').__eq__(True))
print(left_label.is_same_se_shelf_code('YG').__eq__(False))

print('\nTest is_correct_sort_class_no')
print(left_label.is_correct_sort_class_no(right_class_no).__eq__(True))
print(left_label.is_correct_sort_class_no('001.21').__eq__(False))

print('\nTest is_correct_sort_book_code_head')
print(left_label.is_correct_sort_book_code_head(right_book_code_head))

print('\nTest 비교')
print('박' >= '바')
print('하' >= '바')

print('ㅎ' >= '바')
print('각ㄱ' >= '갹')

print(left_label.is_correct_sort_book_code_tail(right_label.book_code_tail))
