# 2022.06.11.

# 124 나라

반복문으로 바꿔도 효율성에서 떨어졌다.

이거면 내가 짠 로직보다 더 효율적인 로직이 있나보다.

이 아이디어로 더 고민하는건 고집인 것 같아

다른 사람들이 한 아이디어를 받아들여야겠다.

## 성공

String 에서 StringBuffer 로 바꿨다.

if 문이 있으면 효율이 떨어지나보다.

```
if (quotient >= 3) {
    n = quotient;
    sb.insert(0, remainder);
} else if (quotient == 0) {
    sb.insert(0, remainder);
    break;
} else {
    sb.insert(0, quotient + "" + remainder);
    break;
}
```

다른 사람 코드를 보니 나눗셈을 한번 더 하는 것 만으로

이 if 문이 필요 없어졌다.

while(true) + break 가 아니라

while (n != 0) 으로도 충분했다.

역시 혼자 생각에 갇히지 말고 좋은 코드를 많이 봐야겠다.
