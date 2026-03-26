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

    static Node node = new Node();

    public static void main(String[] args) {
        String [] words = {"the" , "a" , "there" , "their" , "any"  };
    }
    
}
