class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,Comparator.comparingInt(a->a[1]));
        int arrows = 0;
        long lastArrow = Long.MIN_VALUE;

        for(int[] point : points) {
            if(point[0]>lastArrow) {
                arrows++;
                lastArrow = point[1];
            }
        }
        return arrows;
    }
}