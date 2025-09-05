class MyCalendar {
    List<int[]>bookings;
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        for(int[]booking : bookings) {
            if(startTime<booking[1] && endTime>booking[0])
            return false;
        }
        bookings.add(new int[]{startTime,endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
