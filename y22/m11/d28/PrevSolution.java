package m11.d28;

import java.util.*;

public class PrevSolution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCount = new HashMap<>();
        Map<String, List<Music>> genresMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + play);

            if (genresMap.get(genre) == null) {
                List<Music> list = new ArrayList<>();
                genresMap.put(genre, list);
            }
            genresMap.get(genre).add(new Music(i, genre, play));
        }

        List<String> genreList = new ArrayList<>(genreCount.keySet());
        Collections.sort(genreList, (s1, s2) -> {
            int p1 = genreCount.get(s1);
            int p2 = genreCount.get(s2);
            return p2 - p1;
        });

        List<Integer> genresAlbumList = new ArrayList<>();
        for (String genre : genreList) {
            List<Music> music = genresMap.get(genre);
            music.sort((m1, m2) -> {
                int p1 = m1.playTime;
                int p2 = m2.playTime;
                return p2 - p1;
            });
            genresAlbumList.add(music.get(0).id);
            if (music.size() > 1) {
                genresAlbumList.add(music.get(1).id);
            }
        }

        int[] genresAlbum = new int[genresAlbumList.size()];
        for (int i = 0; i < genresAlbumList.size(); i++) {
            genresAlbum[i] = genresAlbumList.get(i);
        }

        return genresAlbum;
    }
}

class Music {
    int id;
    String genre;
    int playTime;

    public Music(int id, String genre, int playTime) {
        this.id = id;
        this.genre = genre;
        this.playTime = playTime;
    }
}