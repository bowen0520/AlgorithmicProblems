package competition.oneweekrace.oneweekrace164;

public class Test1 {
	public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        for(int i = 1;i<points.length;i++) {
        	sum += min(points[i],points[i-1]);
        }
        return sum;
    }
    
    public int min(int[] p1,int[] p2){
        return Math.max(Math.abs(p1[0]-p2[0]),Math.abs(p1[1]-p2[1]));
    }
}
