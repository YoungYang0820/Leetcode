/**
 * Created by yangjiawei on 2017/6/2.
 */
public class WordDictionary {

    private class Node {
        Node[] children = new Node[26];
        boolean end = false;
    }

    private Node sentinel;
    /** Initialize your data structure here. */
    public WordDictionary() {
        sentinel = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node node = sentinel;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null)
                node.children[index] = new Node();
            node = node.children[index];
        }
        node.end = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word.toCharArray(), 0, sentinel);
    }

    private boolean search(char[] word, int k, Node node) {
        if (node.end && word.length == k) return true;
        else if (word.length == k) return false;
        if (word[k] != '.') {
            return node.children[word[k] - 'a'] != null && search(word, k + 1, node.children[word[k] - 'a']);
        }
        else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null)
                    if (search(word, k + 1, node.children[i]))
                        return true;
            }
        }
        return false;
    }
}
