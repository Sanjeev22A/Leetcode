class Solution {
    long countLessThanOrEqual(int[] nums1,int[] nums2,long x){
        long count=0;
        int n=nums2.length;
        for(int a:nums1){
            if(a>0){
                int left=0,right=n-1;
                int pos=-1;
                while(left<=right){
                    int mid=left+(right-left)/2;
                    
                    long ans=(long)a*nums2[mid];
                    if(ans<=x){
                        pos=mid;
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }
                count+=(pos+1);
            }else if(a<0){
                int left=0,right=n-1,pos=n;
                while(left<=right){
                    int mid=left+(right-left)/2;
                    long ans=(long)a*nums2[mid];
                    if(ans<=x){
                        pos=mid;
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }
                count+=(n-pos);
            }else{
                if(x>=0){
                    count+=n;
                }
            }
        }
        return count;
    }
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -100000L * 100000L;
        long right = 100000L * 100000L;
        while(left<right){
            long mid=left+(right-left)/2;
            if(countLessThanOrEqual(nums1,nums2,mid)>=k){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}