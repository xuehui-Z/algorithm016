/**
* 使用HashMap实现前缀树
*/
class Trie {

    public class TreeNode {
        public boolean endFlg; //单词结尾标志
        public Map<Character,TreeNode> next; //当前字符以及下一个字符的指向
        public TreeNode(boolean endFlg) {
            this.endFlg = endFlg;
            next = new HashMap<Character,TreeNode>();
        }
    }

    private TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode(true);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || "".equals(word)) return;
        TreeNode node = root;
        for (int i=0; i<word.length();i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) {
                node.next.put(ch,new TreeNode(i==word.length()-1));
            } else {
                if (i == (word.length()-1)) node.next.get(ch).endFlg = true;
            }
            node = node.next.get(ch);
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || "".equals(word)) return false;
        boolean result = false;
        TreeNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.next.containsKey(ch)) return false;
            node = node.next.get(ch);
            result = node.endFlg;
        }
        return result;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || "".equals(prefix)) return false;
        TreeNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.next.containsKey(ch)) return false;
            node = node.next.get(ch);
        }
        return true;
    }
}



//老师提供的Java模板，区别在于保存数据的主体是Hash，还是数组
//Java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}