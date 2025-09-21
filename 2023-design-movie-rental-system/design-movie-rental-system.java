class MovieEntry{
    int shop;
    int price;
    MovieEntry(int shop,int price){
        this.shop=shop;
        this.price=price;
    }
}
class Rents{
    int shop,price,movie;
    Rents(int shop,int movie,int price){
        this.shop=shop;
        this.movie=movie;
        this.price=price;
    }
}
class MovieRentingSystem {
    Map<Integer,PriorityQueue<MovieEntry>> movieMap;
    int n;
    Map<String,Integer> shopEntry;
    Set<String> rentedEntry;
    PriorityQueue<Rents> rentedQueue;
    public MovieRentingSystem(int n, int[][] entries) {
        movieMap=new HashMap<>();
        shopEntry=new HashMap<>();
        rentedEntry=new HashSet<>();
        rentedQueue=new PriorityQueue<>((a,b)->{
            if(a.price!=b.price){
                return Integer.compare(a.price,b.price);
            }else if(a.shop!=b.shop){
                return Integer.compare(a.shop,b.shop);
            }
            return Integer.compare(a.movie,b.movie);
        });
        this.n=n;
        for(int[] a:entries){
            MovieEntry mv=new MovieEntry(a[0],a[2]);
            if(!movieMap.containsKey(a[1])){
                PriorityQueue<MovieEntry> pq=new PriorityQueue<>((e,b)->{
                    if(e.price!=b.price){
                        return Integer.compare(e.price,b.price);
                    }
                    return Integer.compare(e.shop,b.shop);
                });
                movieMap.put(a[1],pq);
            }
            movieMap.get(a[1]).offer(mv);
            //Shop first then movie
            shopEntry.put(a[0]+":"+a[1],a[2]);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> res=new ArrayList<>();
        PriorityQueue<MovieEntry> pq=movieMap.get(movie);
        List<MovieEntry> lst=new ArrayList<>();
        if(pq==null){
            return res;
        }
        int count=0;
       
        while(true){

            
            if(pq.isEmpty() || count>=5){
                for(MovieEntry a:lst){
                    pq.offer(a);
                    //System.out.println("----");
                    

                }
                return res;

            }
            //System.out.println(pq.isEmpty());
            MovieEntry e=pq.poll();
            
            String key=e.shop+":"+movie;
            if(!rentedEntry.contains(key) ){
                lst.add(e);
                res.add(e.shop);
               
                count++;
            }else{
                lst.add(e);
            }

        }
        
    }
    
    public void rent(int shop, int movie) {
        String key=shop+":"+movie;
        rentedEntry.add(key);
        rentedQueue.offer(new Rents(shop,movie,shopEntry.get(shop+":"+movie)));
    }
    
    public void drop(int shop, int movie) {
        String key=shop+":"+movie;
        rentedEntry.remove(key);
        
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> res=new ArrayList<>();
        int count=0;
        List<Rents> placeHolder=new ArrayList<>();
        Set<String> seen=new HashSet<>();
        while(true){
            if(rentedQueue.isEmpty() || count>=5){
                for(Rents r:placeHolder){
                    rentedQueue.offer(r);
                }
                return res;
            }
            Rents r=rentedQueue.poll();
            String key=r.shop+":"+r.movie;
            if(rentedEntry.contains(key) && !seen.contains(key)){
                count++;
                List<Integer> temp=new ArrayList<>();
                placeHolder.add(r);
                temp.add(r.shop);
                temp.add(r.movie);
                seen.add(key);
                res.add(temp);
            }
        }
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */