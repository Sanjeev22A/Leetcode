class Solution {
    void flip(int[] arr,int index){
        int i=0,j=index;
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    int findMaxIdx(int[] arr,int n){
        int max=Integer.MIN_VALUE;
        int idx=-1;
        for(int i=0;i<n;i++){
            if(max<arr[i]){
                max=arr[i];
                idx=i;
            }
        }
        return idx;
    }
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans=new ArrayList<>();
        int cur_size=arr.length;
        while(cur_size>1){
            int idx=findMaxIdx(arr,cur_size);
            ans.add(idx+1);
            flip(arr,idx);
            flip(arr,cur_size-1);
            ans.add(cur_size);
            cur_size--;
        }
        return ans;

    }
}