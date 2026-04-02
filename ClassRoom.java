public class ClassRoom {

    static class Node {

        Node [] children ;
        boolean isEndOfWord ;

        public Node(){
            children = new Node[26]; 
            for(Node node : children)
                node = null;
            isEndOfWord =false;

        }


    }

    static Node root = new Node();


    public void insertInTrie(String word){

        Node currNode = root;

        if (word.isBlank()) {
            return ;        
        }
        
        for(int i =0 ;i < word .length(); i++){
             int index = word.charAt(i) -'a';
             if (currNode.children[index]==null) {
                 currNode.children[index]=new Node();

             }
             currNode = currNode.children[index];

            if (i==word.length()-1) {
                currNode.isEndOfWord = false;
             
            }
           


        }




    }

       // INSERT
    public void insertv2(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null)
                curr.children[idx] = new Node();
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }
    
   // STARTS WITH
    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null)
                return false;
            curr = curr.children[idx];
        }
        return true;
    }
    
    
       // SEARCH
    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null)
                return false;
            curr = curr.children[idx];
        }
        return curr.isEndOfWord;
    }
    
    
        // INSERT
    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null)
                curr.children[idx] = new Node();
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }

        // DELETE
    public void delete(String word) {
        deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(Node curr, String word, int depth) {
        if (depth == word.length()) {
            if (!curr.isEndOfWord) return false;
            curr.isEndOfWord = false;
            for (Node child : curr.children)
                if (child != null) return false;
            return true;
        }
        int idx = word.charAt(depth) - 'a';
        if (curr.children[idx] == null) return false;
        boolean canDelete = deleteHelper(curr.children[idx], word, depth + 1);
        if (canDelete) curr.children[idx] = null;
        return canDelete && !curr.isEndOfWord;
    }

       // PRINT all WORDS
    public void printAll() {
        printHelper(root, "");
    }

    private void printHelper(Node curr, String word) {
        if (curr.isEndOfWord)
            System.out.println(word);
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null)
                printHelper(curr.children[i], word + (char)('a' + i));
        }
    }

     public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any"};
        ClassRoom trie = new ClassRoom();

        for (String w : words)
            trie.insert(w);

        trie.printAll();

        System.out.println(trie.search("the"));    // true
        System.out.println(trie.search("them"));   // false
        System.out.println(trie.startsWith("th")); // true

        trie.delete("their");
        System.out.println(trie.search("their"));  // false
        System.out.println(trie.search("there"));  // true
    }
    
    


    
}
