package tree;

public class Trie1 {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie1() {
        root = new Node();

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new Node());
            }
            node = node.get(c);
        }
        node.setEnd();

    }


    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.containsKey(c)) {
                return false;
            }
            node = node.get(c);
        }
        return true;
    }



    private class Node {
        // R links to node children
        private Node[] children;

        private final int R = 26;

        private boolean isEnd;

        public Node() {
            children = new Node[R];
        }

        public boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public void put(char ch, Node node) {
            children[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

    }
}
