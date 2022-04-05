## 2022.03.30.
### 더하기 곱하기 문제
PlusOrMulti

    String s = sc.nextLine();
    int[] a = new int[s.length()];
    
    for (int i = 0; i < s.length(); i++) {
        a[i] = s.charAt(i) - 48;
    }

    int result = a[0];
    for (int i = 0; i < a.length - 1; i++) {
        if (a[i] == 0 || a[i + 1] == 0 || a[i + 1] == 1) {
            result += a[i + 1];
        } else {
            result *= a[i + 1];
        }
    }

int 값으로 변환해 새로운 배열에 넣으려고 처리 했으나

그러지 않고 아래처럼 사용하는 게 시간 복잡도가 줄 듯 

PlusOrMultiSol
    
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    long result = str.charAt(0) - '0';
    for (int i = 1; i < str.length(); i++) {
        int num = str.charAt(i) - '0';
        if (num <= 1 || result <= 1) {
            result += num;
        } else {
            result *= num;
        }
    }

### 모험가 문제
Guild

    int fear[] = new int[n];
    for (int i = 0; i < n; i++) {
        fear[i] = sc.nextInt();
    }
    Arrays.sort(fear);
    ~
        if (fear[i] == team) {
    ~

GuildSol

    public static int n;
    public static ArrayList<Integer> arrayList = new ArrayList<>();
    ~
        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
    ~    
        Collections.sort(arrayList);
    ~
            if (arrayList.get(i) <= count) {

배열을 쓰는 것보다 ArrayList 를 쓰는게 낫겠다. (add, get)



### 소감
DP 문제를 풀고 그리디 문제를 접해서 쉽다고만 생각했다.

그러나 내 실력은 내 생각보다 더 귀여웠다.

더하기 곱하기 문제는 아이디어를 금방 생각하고 구현 했지만 조건대로 받는데 좀 헤멨다

Guild 문제는 아이디어를 찾기는 했으나 어떻게 그 아이디어를 구현할지를 몰랐다.

만만하게 보지 않고 공부 해야겠다.

시간 제한을 두지 않으면 한 없이 빠져드는 것 같아서 기준을 정해야 겠다.

개념 or 1문제 / 2문제

```
아이디어 생각 (2~30분)

확인

구현 (10~20분)

확인
```

