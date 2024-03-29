package leetcode.test0051to0100;

/**
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。

请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 29314
 *
 */
public class Leetcode1232 {
    public boolean checkStraightLine(int[][] coordinates) {
    	if(coordinates.length <= 2) {
    		return true;
    	}
    	
    	
    	if(coordinates[1][0] - coordinates[0][0] == 0) {
    		for(int i = 2 ;i < coordinates.length;i++) {
        		if(coordinates[i][0] != coordinates[0][0]) {
        			return false;
        		}
        	} 
    		return true;
    	}
    	double a = ((double)(coordinates[1][1] - coordinates[0][1]))/(coordinates[1][0] - coordinates[0][0]);
    	double b = coordinates[1][1] - a * coordinates[1][0];
    	
    	
    	
    	for(int i = 2 ;i < coordinates.length;i++) {
    		if(a * coordinates[i][0] + b != coordinates[i][1]) {
    			return false;
    		}
    	}    	
    	
    	return true;
    }
}
