# 2022.11.15.

# 전화 번호 검증

하드코딩 안하고 멋지게 짜보고 싶어서 막 함수로 만들고 짰는데

고려하지 못한 부분에서 오류가 발생 했다.

그리고 결국 if 문 깊이가 너무 깊어 더 보기 안 좋은 코드가 됐다.

* AS-IS

```
if (phone_number.length() >= 7 && "+82-10-".equals(phone_number.substring(0, 7))) {
    phone_number = phone_number.replace("+82-", "0");
    if (validPhoneNumberLength(phone_number)) {
        return 3;
    }
}

if (validPhoneNumberLength(phone_number)) {
    if (phone_number.substring(0, 3).equals("010")) {
        if (phone_number.charAt(3) == '-' && phone_number.charAt(8) == '-') {
            return 1;
        }
        return 2;
    }
}
return -1;
```

* TO-BE

```
if (isTypeOne(phone_number))
    return 1;
if (isTypeTwo(phone_number))
    return 2;
if (isTypeThree(phone_number))
    return 3;
return -1;
```

## SQL

CASE 문, isNull, 집계 함수