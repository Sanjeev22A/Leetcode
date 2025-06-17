class Solution {
    boolean differByOneCharacter(String w1,String w2){
        int count=0;
        if(w1.length()!=w2.length()){
            return false;

        }
        for(int i=0;i<w1.length();i++){
            if(w1.charAt(i)!=w2.charAt(i)){
                count++;
            }
            if(count>1){
                return false;
            }
        }
        return count==1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,Integer> wordSetMap=new HashMap<>();
        for(int i=0;i<wordList.size();i++){
            wordSetMap.put(wordList.get(i),i);
        }
        if(!wordSetMap.containsKey(endWord)){
            return 0;
        }
        if(!wordSetMap.containsKey(beginWord)){
            wordSetMap.put(beginWord,wordList.size());
            wordList.add(beginWord);
        }

        List<HashSet<Integer>> graph=new ArrayList<>();
        for(int i=0;i<wordList.size();i++){
            graph.add(new HashSet<>());
        }
        for(int i=0;i<graph.size();i++){
            for(int j=0;j<graph.size();j++){
                if(i!=j && differByOneCharacter(wordList.get(i),wordList.get(j))){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        Queue<Integer> q=new LinkedList<>();
        q.offer(wordSetMap.get(beginWord));
        int steps=1;
        boolean[] visited=new boolean[wordList.size()];
        while(!q.isEmpty()){
            int size=q.size();
            for(int k=0;k<size;k++){
                int cur=q.poll();
                visited[cur]=true;
                if(wordList.get(cur).equals(endWord)){
                    return steps;
                }
                for(int node:graph.get(cur)){
                    if(!visited[node]){
                        q.offer(node);
                    }
                }
            }
            steps++;
        }
        return 0;

    }
}