package tree;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node("");
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insert(root, word);
    }

    private void insert(Node node, String word) {
        List<Node> nodes = node.getChildren();
        if (nodes.isEmpty()) {
            nodes.add(new Node(word));
            return;
        }
        boolean isStart = false;
        for (Node child : nodes) {
            if (word.equals(child.value)) {
                return;
            } else if (word.startsWith(child.value)) {
                isStart = true;
                insert(child, word.substring(child.value.length()));
            } else if (child.value.startsWith(word)) {

            }
        }
        if (!isStart) {
            nodes.add(new Node(word));
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return search(root, word);
    }

    public boolean search(Node node, String word) {
        if (word.isEmpty()) {
            return false;
        }
        List<Node> nodes = node.getChildren();
        for (Node child : nodes) {
            if (word.startsWith(child.value)) {
                if (word.equals(child.value)) {
                    return true;
                } else {
                    return search(child, word.substring(child.value.length()));
                }
            }
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix);
    }

    private boolean startsWith(Node node, String prefix) {
        if (prefix.isEmpty()) {
            return true;
        }
        List<Node> nodes = node.getChildren();
        for (Node child : nodes) {
            if (prefix.startsWith(child.value)) {
                return startsWith(node, prefix.substring(child.value.length()));
            }
        }
        return false;
    }

    private class Node {
        String value;
        List<Node> children;

        public Node(String value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<Node> getChildren() {
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }
    }
}
