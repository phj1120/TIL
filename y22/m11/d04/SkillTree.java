package y22.m11.d04;

import java.util.HashSet;
import java.util.Set;

public class SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String skillTree = "CBADF";
        String prevSkill = skillTree.replaceAll("[^" + skill + "]", "");
        System.out.println(prevSkill);
    }

    class Solution {
        public int solution(String skill, String[] skill_trees) {
            Set<String> ablePrevSkillTree = new HashSet<>();
            for (int i = 0; i <= skill.length(); i++) {
                ablePrevSkillTree.add(skill.substring(0, i));
            }

            int count = 0;
            for (String skillTree : skill_trees) {
                String prevSkill = skillTree.replaceAll("[^" + skill + "]", "");
                if (ablePrevSkillTree.contains(prevSkill)) {
                    count++;
                }
            }

            return count;
        }
    }
}
