class Solution {
    
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices,(a,b)->{
            return Long.compare((long)a[0],(long)b[0]);
        });
        if(stockPrices.length==1){
            return 0;
        }
        int count = 1; 
        int prevUpper = stockPrices[1][1] - stockPrices[0][1];
        int prevLower = stockPrices[1][0] - stockPrices[0][0];
        
        for (int i = 1; i < stockPrices.length - 1; i++) {
            int upper = stockPrices[i+1][1] - stockPrices[i][1];
            int lower = stockPrices[i+1][0] - stockPrices[i][0];
            
            long d1 = (long) prevUpper * lower;
            long d2 = (long) upper * prevLower;
            
            if (d1 != d2) {
                count++;
            }
            
            prevUpper = upper;
            prevLower = lower;
        }
            
        return count;
            
        }
}