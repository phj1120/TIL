"""
정렬 기준
# ㄱ ㄲ ㄴ ㄷ ㄸ ㄹ ㅁ ㅂ ㅃ ㅛ ㅛ ㅇ ㅈ ㅉ ㅊ ㅋ ㅌ ㅍ ㅎ
# ㅏ ㅐ ㅑ ㅒ ㅓ ㅔ ㅕ ㅖ ㅗ ㅘ ㅙ ㅚ ㅕ ㅛ ㅜ ㅟ ㅞ ㅟ ㅠ ㅡ ㅢ ㅣ

별치 기호 : se_shelf_code / GE
분류 기호 : class_no / 491.508
도서 기호 : book_code_head / ㅊ
          book_code_body / 638
          book_code_tail / ㅅ
권책 기호 : version_code / v.1
          copy_code / c.2
          vol_code

특이 도서 기호 예시
GE 813.6 ㅈ 676 ㅇ3 v.12 c.2
GE 813.6 ㅈ 676 외2
GE 833.6 ㅇ 464 우ㄹ
"""


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
    def is_class_no_smaller_than(self, next_class_no):
        return is_left_less_than_right(self.class_no, next_class_no)

    # 자음
    def is_book_code_head_smaller_than(self, next_book_code_head):
        return is_left_less_than_right(self.book_code_head, next_book_code_head)

    # 정수(필수), 소수점(선택)
    def is_book_code_body_smaller_than(self, next_book_code_body):
        return is_left_less_than_right(self.book_code_body, next_book_code_body)

    # 자음, 문자
    def is_book_code_tail_smaller_than(self, next_book_code_tail):
        # 둘 다 자음인 경우
        if is_start_consonant(self.book_code_tail) and is_start_consonant(next_book_code_tail):
            return is_left_less_than_right(self.book_code_tail, next_book_code_tail)

        # 왼쪽 만 자음인 경우
        if is_start_consonant(self.book_code_tail):
            prevent_start_consonant = self.book_code_tail[0]
            next_start_consonant = extract_first_consonant(next_book_code_tail)
            return is_left_less_than_or_equal_to_right(prevent_start_consonant, next_start_consonant)

        # 오른쪽 만 자음인 경우
        if is_start_consonant(next_book_code_tail):
            prevent_start_consonant = extract_first_consonant(self.book_code_tail)
            next_start_consonant = next_book_code_tail[0]
            return is_left_less_than_right(prevent_start_consonant, next_start_consonant)

        # 둘 다 단어인 경우
        return is_left_less_than_right(self.book_code_tail, next_book_code_tail)

    # v
    def is_correct_sort_version_code(self, next_version_code):
        if self.version_code is None:
            return True
        if next_version_code is None:
            return False
        return is_left_less_than_right(self.version_code, next_version_code)

    # c
    def is_correct_sort_copy_code(self, next_copy_code):
        if self.copy_code is None:
            return True
        if next_copy_code is None:
            return False
        return is_left_less_than_right(self.copy_code, next_copy_code)


def string_to_label(label_string: str):
    label_list = label_string.split()
    if len(label_list) == 7:
        se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, version_code, copy_code = label_string.split()
        label = Label(se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, version_code, copy_code)
    if len(label_list) == 6:
        se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, vol_code = label_string.split()
        if vol_code[0] == 'v':
            label = Label(se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, version_code=vol_code)
        if vol_code[0] == 'c':
            label = Label(se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, copy_code=vol_code)
    if len(label_list) == 5:
        se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail = label_list
        label = Label(se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail)
    return label


def is_left_less_than_or_equal_to_right(left, right):
    return left <= right


def is_left_less_than_right(left, right):
    return left < right


def is_start_consonant(string):
    return 'ㄱ' <= string[0] <= 'ㅎ'


def extract_first_consonant(word):
    CHOSUNG_LIST = ['ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ']
    idx = (ord(word[0]) - ord('가')) // 588
    return CHOSUNG_LIST[idx]


def is_correct_sort(left_label: Label, right_label: Label):
    if not left_label.is_same_se_shelf_code(right_label.se_shelf_code):
        return False

    if left_label.class_no != right_label.class_no:
        return left_label.is_class_no_smaller_than(right_label.class_no)

    if left_label.book_code_head != right_label.book_code_head:
        return left_label.is_book_code_head_smaller_than(right_label.book_code_head)

    if left_label.book_code_body != right_label.book_code_body:
        return left_label.is_book_code_body_smaller_than(right_label.book_code_body)

    if left_label.book_code_tail != right_label.book_code_tail:
        return left_label.is_book_code_tail_smaller_than(right_label.book_code_tail)

    if left_label.version_code != right_label.version_code:
        return left_label.is_correct_sort_version_code(right_label.version_code)

    if left_label.copy_code != right_label.copy_code:
        return left_label.is_correct_sort_copy_code(right_label.copy_code)
    return False


test_label_1 = 'GE 813.6 ㅈ 676 ㅇ3 v.12 c.2'
test_label_2 = 'GE 813.6 ㅈ 676 외2'
test_label_3 = 'GE 833.6 ㅇ 464 우ㄹ'


def test_expected_true(left_label, right_label):
    if is_correct_sort(string_to_label(left_label), string_to_label(right_label)):
        print('Success')
    else:
        print(f'wrong result : expected True but result is False {left_label} / {right_label}')


def test_expected_false(left_label, right_label):
    if not is_correct_sort(string_to_label(left_label), string_to_label(right_label)):
        print('Success')
    else:
        print(f'wrong result : expected False but result is True {left_label} / {right_label}')


test_expected_true(test_label_1, test_label_2)
test_expected_true(test_label_1, test_label_3)
test_expected_true(test_label_2, test_label_3)

test_expected_false(test_label_1, test_label_1)
test_expected_false(test_label_2, test_label_2)
test_expected_false(test_label_3, test_label_3)

test_expected_false(test_label_3, test_label_2)
test_expected_false(test_label_3, test_label_1)
test_expected_false(test_label_2, test_label_1)

"""
TEST CODE
"""
# print('\nTest is_same_se_shelf_code')
# print(left_label.is_same_se_shelf_code('GE').__eq__(True))
# print(left_label.is_same_se_shelf_code('YG').__eq__(False))
#
# print('\nTest is_correct_sort_class_no')
# print(left_label.is_class_no_smaller_than(right_label.class_no).__eq__(True))
#
# print('\nTest is_correct_sort_book_code_head')
# print(left_label.is_book_code_head_smaller_than(right_label.book_code_head))
#
# print('\nTest 비교')
# print('바' <= '박')
# print('박' <= '하')
# print(('바' <= 'ㅎ').__eq__(False))
# print('바' <= '하')
# print('각ㄱ' <= '갹')
#
# print(left_label.is_book_code_tail_smaller_than(right_label.book_code_tail))
#
# right_label = 'GE 493 ㅎ 82 ㄱ'
# left_label = 'GE 491.508 ㅊ 638 각 v.1 c.2'
# print(is_correct_sort(left_label, right_label))
#
# print('Test 시작')
# print('ㅇ2' < 'ㅇ3')
# print('ㅇ3' < '외2')
# print('외2' < '우')
# print('ㅇ' < '우')
#
# ㅏ ㅐ ㅑ ㅒ ㅓ ㅔ ㅕ ㅖ ㅗ ㅘ ㅙ ㅚ ㅛ ㅜ ㅞ ㅟ ㅠ ㅡ ㅢ ㅣ
# print('아' < '애')
# print('애' < '야')
# print('야' < '얘')
# print('얘' < '어')
# print('어' < '에')
# print('에' < '여')
# print('여' < '예')
# print('예' < '오')
# print('오' < '와')
# print('와' < '왜')
# print('왜' < '외')
# print('외' < '요')
# print('요' < '우')
# print('우' < '웨')
# print('웨' < '위')
# print('위' < '유')
# print('유' < '으')
# print('으' < '의')
# print('의' < '이')
