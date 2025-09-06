class MyCalendarTwo {
    List<int[]>bookings;
    List<int[]>overlaps;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[]overlap : overlaps) {
            if(startTime<overlap[1] && endTime>overlap[0]) {
                return false;
            }
        }
        for(int[] booking : bookings) {
            if(startTime<booking[1]&& endTime>booking[0]) {
                overlaps.add(new int[] {
                    Math.max(startTime,booking[0]),
                    Math.min(endTime,booking[1])
                });
            }
        }
        bookings.add(new int[]{startTime,endTime});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */
