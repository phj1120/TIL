package m11.d28;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] correctAnswer = {4, 1, 3, 0};
        Solution solution = new Solution();

        int[] answer = solution.solution(genres, plays);

        System.out.println(Arrays.equals(answer, correctAnswer));
        System.out.println(Arrays.toString(answer));
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. genre 초기화
        Map<String, List<Music>> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            int play = plays[i];
            String genre = genres[i];
            List<Music> list = genreMap.getOrDefault(genre, new ArrayList<>());
            list.add(new Music(i, genre, play));
            genreMap.put(genre, list);
        }

        // 2. genre 의 value 값 정렬
        for (List<Music> value : genreMap.values()) {
            Collections.sort(value);
        }

        // 3. genre key 개당 장르 전체의 재생 회수로 정렬
        List<String> sortGenres = genreMap.keySet().stream()
                .sorted((s1, s2) -> {
                    return getGenrePlayTime(genreMap.get(s2)) - getGenrePlayTime(genreMap.get(s1));
                })
                .collect(Collectors.toList());

        // 4. 1 ~ 2개 꺼내 배열에 저장
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < sortGenres.size(); i++) {
            String genre = sortGenres.get(i);
            for (int j = 0; j < Math.min(genreMap.get(genre).size(), 2); j++) {
                answer.add(genreMap.get(genre).get(j).getId());
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public int getGenrePlayTime(List<Music> musics) {
        return musics.stream().mapToInt(m -> m.getPlayTime()).sum();
    }

}

class Music implements Comparable<Music> {
    private int id;
    private int playTime;
    private String genre;

    public Music(int id, String genre, int playTime) {
        this.id = id;
        this.genre = genre;
        this.playTime = playTime;
    }

    @Override
    public int compareTo(Music music) {
        return music.playTime - playTime;
    }

    public int getId() {
        return id;
    }

    public int getPlayTime() {
        return playTime;
    }
}



