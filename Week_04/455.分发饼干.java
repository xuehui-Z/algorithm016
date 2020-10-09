class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int level = 0;
        for (int i=0;i<g.length;i++) {
            while (level < s.length) {
                if (s[level++] >= g[i]) {
                    contentChildren++;
                    break;
                }
            }
        }
        return contentChildren;
    }
}
