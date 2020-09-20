/*
 解法一：；利用HashMap
		遍历第一个字符串，value为出现次数
		遍历第二个字符串，获取当前字符，将value值减一
		最后看map中的所有value值是不是0
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> sUtil = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            sUtil.put(s.charAt(i),sUtil.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i=0;i<t.length();i++) {
            sUtil.put(t.charAt(i),sUtil.getOrDefault(t.charAt(i),0)-1);
        }
        for (Map.Entry<Character,Integer> entry : sUtil.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}
/*
 解法一：；排序+比较
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        String newS = String.valueOf(arrS);
        String newT = String.valueOf(arrT);
        return newS.equals(newT);
    }
}