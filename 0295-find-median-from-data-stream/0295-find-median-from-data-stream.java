class MedianFinder {
    PriorityQueue<Integer> min = new  PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
        
    }
    public  void balance(){
        if(max.size()>min.size()+1){
            int ele = max.poll();
            min.offer(ele);
        }
        else if(min.size()>max.size()+1){
            int ele = min.poll();
            max.offer(ele);
        }
    }
    public void addNum(int num) {
        if(max.isEmpty() || num<=max.peek()){
            max.offer(num);
        }
        else {
            min.offer(num);
        }
        balance();
    }
    
    public double findMedian() {
       int size = min.size()+max.size();
       if(size%2==1){
         if(min.size()>max.size()) return (double)min.peek();
         else return (double)max.peek();
       }
       return (max.peek() + min.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */