class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph=new int[numCourses][numCourses];
        int[] indegree=new int[numCourses];
        List<Integer> finalAr=new ArrayList<>();
        for(int[] a:prerequisites){
            if(a[1]==a[0]){
                return false;
            }
            graph[a[1]][a[0]]=1;  //graph[i][j] means to complete j we need to complete i
            indegree[a[0]]++;
        }

        Queue<Integer> a=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                a.offer(i);
            }
        }
        while(!a.isEmpty()){
            int node=a.poll();
            finalAr.add(node);
            for(int i=0;i<numCourses;i++){
                if(graph[node][i]==1){
                    indegree[i]--;
                    if(indegree[i]==0){
                        a.offer(i);
                    }
                }
            }

        }
        if(finalAr.size()!=numCourses){
            return false;
        }
        return true;


        
    }
}