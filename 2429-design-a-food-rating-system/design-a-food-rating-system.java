class Food{
    String foodname;
    int rating;
    Food(String foodname,int rating){
        this.foodname=foodname;
        this.rating=rating;
    }
}
class FoodRatings {
    Map<String,Food> foodMap;
    Map<String,PriorityQueue<Food>> cuisineMap;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foodMap=new HashMap<>();
        this.cuisineMap=new HashMap<>();
        for(int i=0;i<foods.length;i++){
            if(!cuisineMap.containsKey(cuisines[i])){
                cuisineMap.put(cuisines[i],new PriorityQueue<>((a,b)->{
                    if(a.rating!=b.rating){
                        return Integer.compare(b.rating,a.rating);
                    }else{
                        return a.foodname.compareTo(b.foodname);
                    }
                    
            }));
            }
            foodMap.put(foods[i],new Food(cuisines[i],ratings[i]));
            cuisineMap.get(cuisines[i]).add(new Food(foods[i],ratings[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food f=foodMap.get(food);
        f.rating=newRating;
        cuisineMap.get(f.foodname).add(new Food(food,newRating));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Food> pq=cuisineMap.get(cuisine);
        while(true){
            Food f=pq.poll();
            if(f.rating==foodMap.get(f.foodname).rating){
                pq.offer(f);
                return f.foodname;
            }
        }
       
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */