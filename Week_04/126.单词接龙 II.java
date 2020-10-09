class Solution {
    int minChange = Integer.MAX_VALUE;
    List<List<String>> result;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        result = new ArrayList<List<String>>();
        if (wordList.size() == 0) return result;

        char[][] words = new char[wordList.size()][wordList.get(0).length()];
        for (int i = 0; i < wordList.size(); i++) {
            words[i] = wordList.get(i).toCharArray();
        }
        List<String> curList = new ArrayList<>();
        curList.add(beginWord);
        dfs(words, beginWord.toCharArray(), endWord.toCharArray(), curList, 1);
        return result;
    }

    private void dfs(char[][] words, char[] chrStart, char[] chrEnd, List<String> curList, int level) {
        if (level > minChange) return;
        if (Arrays.equals(chrStart, chrEnd)) {
            if (level <= minChange) {
                if (level != minChange) result.clear();
                result.add(new ArrayList<>(curList));
                minChange = level;
                return;
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i] == null) continue;
            char[] peek = words[i];
            int diff = 0;
            for (int j = 0; j < chrStart.length; j++) {
                if (chrStart[j] != peek[j]) diff++;
            }
            if (diff == 1) {
                words[i] = null;
                curList.add(String.valueOf(peek));
                dfs(words, peek, chrEnd, curList, level + 1);
                words[i] = peek;
                curList.remove(curList.size() - 1);
            }
        }

    }
}