import java.util.*;

/**
 * 
 * 
 * 
 * Given a list of product names and a search query string, return a list of suggested products after each character is typed. At each step, return at most 3 lexicographically smallest products that start with the current prefix.
 * 
 * products = ["mobile", "mouse", "moneypot", "monitor", "mousepad"]
query    = "mouse"

Output:
After 'm'     → ["mobile", "moneypot", "monitor"]
After 'mo'    → ["mobile", "moneypot", "monitor"]
After 'mou'   → ["mouse", "mousepad"]
After 'mous'  → ["mouse", "mousepad"]
After 'mouse' → ["mouse", "mousepad"]
 * 
 * 
 * 
 */

public class SearchSuggestions {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    static void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];

            node.suggestions.add(word);
            Collections.sort(node.suggestions);
            if (node.suggestions.size() > 3) {
                node.suggestions.remove(node.suggestions.size() - 1);
            }
        }
    }

    static List<List<String>> search(TrieNode root, String query) {
        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;

        for (char c : query.toCharArray()) {
            int idx = c - 'a';
            if (node != null) {
                node = node.children[idx];
            }
            result.add(node == null ? new ArrayList<>() 
                                    : new ArrayList<>(node.suggestions));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", 
                             "monitor", "mousepad"};
        String query = "mouse";

        Arrays.sort(products);

        TrieNode root = new TrieNode();
        for (String product : products) {
            insert(root, product);
        }

        List<List<String>> result = search(root, query);

        String prefix = "";
        for (int i = 0; i < query.length(); i++) {
            prefix += query.charAt(i);
            System.out.println("After '" + prefix + "' → " + result.get(i));
        }
    }
}