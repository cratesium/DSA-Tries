public abstract class TrieNode {

    TrieNode [] nodes ;
    boolean isEndOfWord;
     //assuming it to be small case only so initialize with 26 otherwise in general 256 
    public TrieNode(){
        nodes = new TrieNode[26];
        for(TrieNode node : nodes){
            node = null;
        }
        isEndOfWord = false;

     //comment to check ssh working 


    }
    
    
}
