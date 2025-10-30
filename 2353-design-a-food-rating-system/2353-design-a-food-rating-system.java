class FoodRatings {
    Map<String, PriorityQueue<FoodItem>> ratingMap = new HashMap<>();
    Map<String,String> cuisine = new HashMap<>();
    Map<String,Integer> rating = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        Comparator<FoodItem> cmp = (a,b)-> a.rating==b.rating ? a.food.compareTo(b.food) : b.rating-a.rating;
        for(int i=0; i<foods.length; i++) {
            ratingMap.putIfAbsent(cuisines[i], new PriorityQueue(cmp));
            ratingMap.get(cuisines[i]).offer(new FoodItem(foods[i],ratings[i]));
            cuisine.put(foods[i],cuisines[i]);
            rating.put(foods[i], ratings[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisines = cuisine.get(food);
        rating.put(food,newRating);
        ratingMap.get(cuisines).offer(new FoodItem(food,newRating));
    }
    
    public String highestRated(String cuisine) {
      PriorityQueue<FoodItem> heap = ratingMap.get(cuisine);
      FoodItem top = heap.peek();
      while(rating.get(top.food)!=top.rating) {
        heap.poll();
        top = heap.peek();
      }
      return top.food;

    }

    class FoodItem {
        String food;
        int rating;
        public FoodItem(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */