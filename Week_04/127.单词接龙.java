class Solution {
    int minChange = Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) return 0;
        char[][] words = new char[wordList.size()][wordList.get(0).length()];
        for (int i=0;i<wordList.size();i++) {
            words[i] = wordList.get(i).toCharArray();
        }
        dfs(words,beginWord.toCharArray(),endWord.toCharArray(),1);
        return minChange==Integer.MAX_VALUE ? 0 : minChange;
    }
    public void dfs(char[][] words,char[] start,char[] end,int len) {
        if (Arrays.equals(start,end)) {
            minChange = Math.min(minChange,len);
            return;
        }
        for (int i=0;i<words.length;i++) {
            if (words[i] == null) continue;
            char[] peek = words[i];
            int diff = 0;
            for (int j=0;j<start.length;j++) {
                if (start[j] != peek[j]) diff++;
            }
            if (diff == 1) {
                words[i] = null;
                dfs(words,peek,end,len+1);
                words[i] = peek;
            }
        }
    }
}