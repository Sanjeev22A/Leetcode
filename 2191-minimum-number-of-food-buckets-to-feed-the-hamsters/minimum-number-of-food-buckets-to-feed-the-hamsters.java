class Solution {
    public int minimumBuckets(String hamsters) {

        char[] arr=hamsters.toCharArray();
        if(arr.length==1){
            if(arr[0]=='H'){
                return -1;
            }
            return 0;
        }
        int add=0;
        for(int i=1;i<arr.length-1;i++){
            if((arr[i-1]=='H' || arr[i-1]=='F' ) && (arr[i+1]=='H' || arr[i+1]=='F' ) && (arr[i]=='H' || arr[i]=='F' )){
                return -1;
            }
            if(arr[i-1]=='H' && arr[i+1]=='H'){
                if(arr[i]=='H' || arr[i]=='F'){
                    return -1;
                }else{
                    arr[i]='B';
                    arr[i-1]='F';
                    arr[i+1]='F';
                    add++;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            if(i==0 && arr[i]=='H'){
                if(arr[i+1]=='H' || arr[i+1]=='F'){
                    return -1;
                }else if(arr[i+1]=='.'){
                    arr[i+1]='B';
                    add++;
                }
            }
            else if(i==arr.length-1 && arr[i]=='H'){
                if(arr[i-1]=='H' || arr[i-1]=='F'){
                    return -1;
                }else if(arr[i-1]=='.'){
                    arr[i-1]='B';
                    add++;
                }
            }
            else{
                if(arr[i]=='H' && arr[i-1]!='B' && arr[i+1]!='B'){
                    add++;
                    if(arr[i+1]=='.'){
                        arr[i+1]='B';
                    }else{
                        arr[i-1]='B';
                    }
                }
            }
        }
        return add;
    }
}