package m11.d28;

import java.util.*;

public class BestAlbum {

    public static void main(String[] args) {


    }

    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            // 1. genre 초기화
            Map<String, List<Music>> genreMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                String genre = genres[i];
                List<Music> list = genreMap.getOrDefault(genre, new ArrayList<>());
                int play = plays[i];
                list.add(new Music(i, play, genre));
            }

            // 2. genre 의 value 값 정렬
            for (List<Music> value : genreMap.values()) {
                Collections.sort(value);
            }

            // 3. genre key 개당 장르 전체의 재생 회수로 정렬
            List<String> sortGenres = new ArrayList<>();

            // 4. 1 ~ 2개 꺼내 배열에 저장


            int[] answer = {};
            return answer;
        }
    }


    static class Music implements Comparable<Music> {
        private int id;
        private int playTime;
        private String genre;

        public Music(int id, int playTime, String genre) {
            this.id = id;
            this.playTime = playTime;
            this.genre = genre;
        }

        @Override
        public int compareTo(Music music) {
            return playTime - music.playTime;
        }
    }

}


