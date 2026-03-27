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

    public static void main(String[] args) {
        String [] words = {"the" , "a" , "there" , "their" , "any"  };
    }
    
}
