package leetcode.test0451to0500;

import java.util.Random;

public class Leetcode478 {
	
	
	class Solution {
	    private double radius;
	    private double x_center;
	    private double y_center;
	    
	    private Random random;

	    public Solution(double radius, double x_center, double y_center) {
	        this.radius = radius;
	        this.x_center = x_center;
	        this.y_center = y_center;
	        random = new Random();
	        //Math.random()
	        //random.
	    }
	    
	    public double[] randPoint() {
	        while(true) {
	        	boolean xFlag = random.nextBoolean();
	        	double x = random.nextInt(100000001);
	        	x = x / 100000000 * radius;
	        	x = xFlag ? x : -x;
	        	
	        	boolean yFlag = random.nextBoolean();
	        	double y = random.nextInt(100000001);
	        	y = y / 100000000 * radius;
	        	y = yFlag ? y : -y;
	        	
	        	if(x * x + y * y <= radius * radius) {
	        		return new double[] {x + x_center, y + y_center};
	        	}
	        }
	    }
	}
}


