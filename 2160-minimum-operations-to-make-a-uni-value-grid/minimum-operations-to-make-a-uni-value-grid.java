class Solution {
    public int minOperations(int[][] grid, int x) {
        Set<Integer> rem=new HashSet<>();
        List<Integer> arr=new ArrayList<>();
        for(int[] a:grid){
            for(int b:a){
                int r=b%x;
                rem.add(r);
                if(rem.size()>1){
                    return -1;
                }
                arr.add(b);
            }
        }
        Collections.sort(arr,(a,b)->Integer.compare(a,b));
        long[] prefix=new long[arr.size()];
        long[] suffix=new long[arr.size()];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<arr.size();i++){
            long a=0L;
            if(i>0){
                a=prefix[i-1];
            }
            prefix[i]=a+(long)arr.get(i);
        }
        for(int i=arr.size()-1;i>=0;i--){
            long a=0L;
            if(i<arr.size()-1){
                a=suffix[i+1];
            }
            suffix[i]=a+(long)arr.get(i);
        }

        for(int i=0;i<arr.size();i++){
            long prefixSum=0L,suffixSum=0L;
            int prefixCount=0,suffixCount=0;
            if(i>0){
                prefixSum=prefix[i-1];
                prefixCount=i;
            }
            if(i<arr.size()-1){
                suffixSum=suffix[i+1];
                suffixCount=arr.size()-i-1;
            }
            long before=(long)prefixCount*(long)arr.get(i);
            long after=(long)suffixCount*(long)arr.get(i);
            long diff=(before-prefixSum)+(suffixSum-after);

            int count=(int)(diff/(long)x);
            ans=Math.min(count,ans);
        }
        return ans;

    }
}