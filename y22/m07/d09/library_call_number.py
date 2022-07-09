labels = ['GE 491.508 ㅊ 638 ㅅ v.1 c.2']
# for label in labels:
#     se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, version_code, copy_code = label.split(' ')
#     print(se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, version_code, copy_code)

'''
별치 기호 : se_shelf_code
분류 기호 : class_no
도서 기호 : book_code_head, book_code_body, book_code_tail
권책 기호 : version_code, copy_code
'''


class Label:
    def __init__(self, se_shelf_code, class_no, book_code_head, book_code_body,
                 book_code_tail, version_code, copy_code) -> None:
        self.se_shelf_code = se_shelf_code
        self.class_no = class_no
        self.book_code_head = book_code_head
        self.book_code_body = book_code_body
        self.book_code_tail = book_code_tail
        self.version_code = version_code
        self.copy_code = copy_code

    def __str__(self) -> str:
        return f'se_shelf_code : {se_shelf_code}, class_no : {class_no}, ' \
               f'book_code_head : {book_code_head}, book_code_body : {book_code_body},' \
               f'book_code_tail : {book_code_tail}, version_code : {version_code}, copy_code : {copy_code}'


left_label = 'GE 491.508 ㅊ 638 ㅅ v.1 c.2'
se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, version_code, copy_code = left_label.split(' ')
left_label = Label(se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, version_code, copy_code)
print(left_label)

right_label = 'GE 491 ㅎ 82 ㄱ v.1 c.2'
se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, version_code, copy_code = right_label.split(
    ' ')
right_label = Label(se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, version_code, copy_code)
print(right_label)


def make_label_list(label_string):
    se_shelf_code, class_no, book_code_head, book_code_body, book_code_tail, version_code, copy_code = label.split(' ')


def correct_sort(left_label, right_label):
    pass


correct_sort(left_label, right_label)
