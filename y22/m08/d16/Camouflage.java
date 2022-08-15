package y22.m08.d16;

import java.util.*;

public class Camouflage {
    class MySolution {
        public int solution(String[][] clothes) {
            Map<String, List> clothGroups = new HashMap<>();
            for (String[] cloth : clothes) {
                String clothName = cloth[0];
                String clothType = cloth[1];
                if (clothGroups.get(clothType) == null) {
                    List<String> clothList = new ArrayList<>();
                    clothList.add(clothName);
                    clothGroups.put(clothType, clothList);
                } else {
                    clothGroups.get(clothType).add(clothName);
                }
            }

            int combinationCount = 1;
            for (List cloths : clothGroups.values()) {
                combinationCount *= (cloths.size() + 1);
            }
            return combinationCount - 1;
        }
    }

    class LectureSolution {
        public int solution(String[][] clothes) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String[] cloth : clothes) {
                String type = cloth[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            Iterator<Integer> it = map.values().iterator();
            int answer = 1;
            while (it.hasNext()) {
                answer *= it.next().intValue() + 1;
            }
            return answer -1;
        }
    }


}
