
class MyCalendar {
    List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Check if the new event overlaps with any existing events
        for (int[] event : calendar) {
            int existingStart = event[0];
            int existingEnd = event[1];
            
            // Overlap condition: start < existingEnd and existingStart < end
            if (start < existingEnd && existingStart < end) {
                return false;  // There is an overlap, so booking is not possible
            }
        }

        // No overlap, add the new event
        calendar.add(new int[]{start, end});
        return true;
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */