def test(name, age):
    return f'{name} 은 {age} 살 입니다'


arr = [test('phj', 24), test('park', 25)]

print(arr)

asia = {'한국', '중국', '일본'}
print(asia)
asia.add('베트남')
print(asia)
asia.add('베트남')
print(asia)
asia.update({'태국', '한국'})
print(asia)
