class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] arr=new boolean[numCourses][numCourses];
        for(int[] a:prerequisites){
            arr[a[0]][a[1]]=true;
        }
        for(int k=0;k<numCourses;k++){
            for(int i=0;i<numCourses;i++){
                for(int j=0;j<numCourses;j++){
                    if(arr[i][k] && arr[k][j]){
                        arr[i][j]=true;
                    }
                }
            }
        }
        List<Boolean> result=new ArrayList<>();
        for(int[] a:queries){
            result.add(arr[a[0]][a[1]]);
        }
        return result;
    }
}