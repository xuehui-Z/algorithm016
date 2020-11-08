// 创建包含26个英文字母的数组
// 将s中的字母分配到数组中
// 根据t，收集数组中的元素
// 判断收集状态，若刚好收集完成，则为有效，否则无效

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] anagram = new int[26];
        for (char cs : s.toCharArray()) {
            anagram[cs-'a']++;
        }
        for (char ct : t.toCharArray()) {
            anagram[ct-'a']--;
        }
        for (int i : anagram) if (i != 0) return false;
        return true;

    }
}