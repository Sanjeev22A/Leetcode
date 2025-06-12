class Solution {
    int binarySearch(int val, List<Integer> buckets) {
        int leftMostGreater = buckets.size();
        int l = 0, r = buckets.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (buckets.get(mid) >= val) {
                leftMostGreater = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return buckets.size() - leftMostGreater;
    }
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<List<Integer>> buckets=new ArrayList<>();
        for(int i=0;i<=101;i++){
            buckets.add(new ArrayList<>());
        }
        //Put the y coords in the bucket
        for(int[] a:rectangles){
            buckets.get(a[1]).add(a[0]);
        }
        for(List<Integer> a:buckets){
            Collections.sort(a);  //Sorting the lists in ascending order for binary search
        }

        int[] res=new int[points.length];
        int i=0;
        for(int[] a:points){
            int count=0;

            for(int y=a[1];y<=100;y++){
                List<Integer> cur=buckets.get(y);
                count+=binarySearch(a[0],cur);
            }
            res[i++]=count;
        }
        return res;

    }
}