class Node{
    char c;
    List<Node> lst;
    boolean isLeaf;
    Node(char c){
        this.c=c;
        this.lst=new ArrayList<>();
        this.isLeaf=true;
    }
    Node(){
        this.c=' ';
        this.lst=new ArrayList<>();
        this.isLeaf=true;
    }
    void addNode(Node a){
        lst.add(a);
        this.isLeaf=false;
    }
}

class Trie{
    Node root;
    Trie(){
        root=new Node('$');  //$ as start symbol
    }
    void add(String word){
        word=word+"$";
        Node prev=root;
        int i=0;
        for(char c:word.toCharArray()){
            boolean flag=false;
            for(Node a:prev.lst){
                if(a.c==c){
                    flag=true;
                    prev=a;
                    if(i==word.length()-1){
                        prev.isLeaf=true;
                    }
                    break;
                }
            }
            if(!flag){
                Node a=new Node(c);
                prev.addNode(a);
                prev=a;
                if(i==word.length()-1){
                    prev.isLeaf=true;
                }
            }
            i++;

        }
    }

    boolean search(String word){
        word=word+"$";
        boolean flag=false;
        for(Node a:root.lst){
            flag=flag||dfs(0,word,a);
        }
        return flag;
    }
    boolean dfs(int index,String word,Node n){
        
        if(index==word.length()-1 && n.isLeaf && ( n.c==word.charAt(index) || word.charAt(index)=='.')){
            
            return true;
        }
        boolean flag=false;
        if(word.charAt(index)==n.c || word.charAt(index)=='.'){
            
            for(Node a:n.lst){

                flag=flag || dfs(index+1,word,a);
                
            }
            return flag;
        }
        return flag;
    }
}
class WordDictionary {
    Trie t;
    public WordDictionary() {
        t=new Trie();
    }
    
    public void addWord(String word) {
        t.add(word);
    }
    
    public boolean search(String word) {
        return t.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */