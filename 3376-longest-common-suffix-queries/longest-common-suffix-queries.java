class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int minLength = Integer.MAX_VALUE;
        int minIndex = -1;
    }

    private TrieNode root = new TrieNode();

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int globalMinIndex = 0;
        for (int i = 0; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[globalMinIndex].length()) {
                globalMinIndex = i;
            }
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            int res = search(wordsQuery[i]);
            ans[i] = (res == -1) ? globalMinIndex : res;
        }

        return ans;
    }

    private void insert(String word, int index) {
        TrieNode curr = root;
        int len = word.length();
        
        if (len < curr.minLength) {
            curr.minLength = len;
            curr.minIndex = index;
        }

        for (int i = len - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (curr.children[c] == null) {
                curr.children[c] = new TrieNode();
            }
            curr = curr.children[c];
            if (len < curr.minLength) {
                curr.minLength = len;
                curr.minIndex = index;
            }
        }
    }

    private int search(String query) {
        TrieNode curr = root;
        int res = root.minIndex;
        
        for (int i = query.length() - 1; i >= 0; i--) {
            int c = query.charAt(i) - 'a';
            if (curr.children[c] == null) {
                break;
            }
            curr = curr.children[c];
            res = curr.minIndex;
        }
        return res;
    }
}