import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Leetcode.FindWords;
import Leetcode.list.CopyRandomList;
import Leetcode.list.SortList;
import org.junit.Test;
import tree.Trie;


public class test1 {
    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // 返回 true
        System.out.println(trie.search("app"));// 返回 false
        System.out.println(trie.startsWith("app"));// 返回 true
        trie.insert("app");
        System.out.println(trie.search("app"));// 返回 true

    }

    @Test
    public void testFindWords() {
        FindWords findWords = new FindWords();
        String[] words = new String[] {"oath", "pea", "eat", "rain"};
        char[][] board = new char[][] {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}};
        for (String s : findWords.solution(board, words)) {
            System.out.println(s);
        }

    }

    @Test
    public void testFindWords2() {
        FindWords findWords = new FindWords();
        String[] words = new String[] {"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"};
        char[][] board = new char[][] {
            {'a', 'b'},
            {'a', 'a'}};
        for (String s : findWords.solution(board, words)) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() {
        Set<String> set = new HashSet<>();
        System.out.println(set.add("1"));
        System.out.println(set.add("1"));

    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(123);
        }
    }

    @Test
    public void test4() {
        CopyRandomList copyRandomList = new CopyRandomList();

        CopyRandomList.Node node = new CopyRandomList().new Node(1, null, null);
        CopyRandomList.Node node1 = new CopyRandomList().new Node(1, null, null);
        CopyRandomList.Node node2 = new CopyRandomList().new Node(1, null, null);
        CopyRandomList.Node node3 = new CopyRandomList().new Node(1, null, null);
        node.next = node1;
        node1.next = node2;
        node.random = node3;
        CopyRandomList.Node node4 = copyRandomList.copyRandomList(node);
    }

    @Test
    public void test5() {
        SortList sortList = new SortList();
        SortList.ListNode node = new SortList().new ListNode(4);
        SortList.ListNode node1 = new SortList().new ListNode(2);
        SortList.ListNode node2 = new SortList().new ListNode(1);
        SortList.ListNode node3 = new SortList().new ListNode(5);
        SortList.ListNode node4 = new SortList().new ListNode(3);


        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SortList.ListNode ans = sortList.sortList(node);
    }
}
