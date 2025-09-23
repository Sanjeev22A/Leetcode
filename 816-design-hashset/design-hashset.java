class MyHashSet {
    int[] map;
    int lim=(int)Math.pow(10,6)+1;
    public MyHashSet() {
        map=new int[lim];
        Arrays.fill(map,-1);
    }
    
    public void add(int key) {
        map[key]=1;
    }
    
    public void remove(int key) {
        map[key]=-1;
    }
    
    public boolean contains(int key) {
        return (map[key]!=-1);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */