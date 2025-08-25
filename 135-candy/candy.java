class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] candies=new int[n];
        //Init stage -  every child with 1 candy
        for(int i=0;i<n;i++){
            candies[i]=1;
        }

        //left to right pass - compare with left child
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=Math.max(candies[i],candies[i-1]+1);
            }
        }

        //right to left pass - compare with right child
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }
        
        int sum=0;
        for(int a:candies){
            sum+=a;
            //System.out.print(a+" ");
        }
        
        
        return sum;
    }
}