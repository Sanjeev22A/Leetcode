class ProductOfNumbers {
    List<Integer> arr;
    int top=0;
    public ProductOfNumbers() {
        arr=new ArrayList<>();
    }
    
    public void add(int num) {
        if(!arr.isEmpty()){
            if(num!=0){
                arr.add(arr.get(top-1)*num);
                top++;
            }else{
                arr=new ArrayList<>();
                top=0;
            }
        }
        else{
            if(num!=0){
                arr.add(num);
                top++;
            }else{
                arr.clear();
                top=0;
            }
        }
    }
    
    public int getProduct(int k) {
        if(top==k){
            return arr.get(k-1);
        }
        else if(top>k){
            return arr.get(top-1)/arr.get(top-k-1);
        }else{
            return 0;
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */