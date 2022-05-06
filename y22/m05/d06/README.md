# 2022.05.06.

# 2019 KAKAO BLIND RECRUITMENT 오픈채팅방

User 와 Log 를 클래스로 만들어서 구현했다.

log 는 클래스가 아니라 Map 으로 했어도 됐을 것 같다.

User 를 클래스로 해서 List 에 담아서 관리 했다.

그래서 User 가 있는지 없는지 검색하는데 시간이 너무 오래 걸려 시간 초과가 났다.

어떻게 수정해야 할 지 생각해 봐야겠다.

static ArrayList<HashMap<String, User>> userMap = new ArrayList<>();

[{id : User}, {id : User}....] 이렇게 map 으로 관리 하면 User 하나 하나 다 비교할 필요 없지 않을까...

근데 이렇게 하면 코드가 지금보다 더 더러워지는거 아닌가?

id, name 각각 ArrayList 만들어서 index 로 유저 구분할 수도 있을것 같다.