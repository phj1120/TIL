package y22.m05.d28;

class FastSol {
    public int solution(int n, String[] data) {
        char[] s = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

        int count = 0;

        for (int a = 0; a < s.length; a++) {
            for (int b = 0; b < s.length; b++) {
                if (b == a) {
                    continue;
                }
                for (int c = 0; c < s.length; c++) {
                    if (c == a || c == b) {
                        continue;
                    }
                    for (int d = 0; d < s.length; d++) {
                        if (d == c || d == a || d == b) {
                            continue;
                        }
                        for (int e = 0; e < s.length; e++) {
                            if (e == d || e == a || e == b || e == c) {
                                continue;
                            }
                            for (int f = 0; f < s.length; f++) {
                                if (f == e || f == d || f == c || f == b || f == a) {
                                    continue;
                                }
                                for (int g = 0; g < s.length; g++) {
                                    if (g == a || g == b || g == c || g == d || g == e || g == f) {
                                        continue;
                                    }
                                    for (int h = 0; h < s.length; h++) {
                                        if (h == a || h == b || h == c || h == d || h == e || h == f || h == g) {
                                            continue;
                                        }
                                        String makeS = "" + s[a] + s[b] + s[c] + s[d] + s[e] + s[f] + s[g] + s[h];

                                        boolean isCheck = false;
                                        for (int i = 0; i < data.length; i++) {
                                            char first = data[i].charAt(0);
                                            char second = data[i].charAt(2);
                                            char inequality = data[i].charAt(3);
                                            int distance = data[i].charAt(4) - 48;

                                            int firstIndex = makeS.indexOf(first);
                                            int secondIndex = makeS.indexOf(second);
                                            switch (inequality) {
                                                case '=': {
                                                    if (Math.abs(firstIndex - secondIndex) == distance + 1) {
                                                        isCheck = true;
                                                    } else
                                                        isCheck = false;
                                                    break;
                                                }
                                                case '>': {
                                                    if (Math.abs(firstIndex - secondIndex) > distance + 1) {
                                                        isCheck = true;
                                                    } else
                                                        isCheck = false;
                                                    break;
                                                }
                                                case '<': {
                                                    if (Math.abs(firstIndex - secondIndex) < distance + 1) {
                                                        isCheck = true;
                                                    } else
                                                        isCheck = false;
                                                    break;
                                                }
                                            }
                                            if (isCheck == false) {
                                                break;
                                            }
                                        }
                                        if (isCheck) {
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
        return count;
    }
}
