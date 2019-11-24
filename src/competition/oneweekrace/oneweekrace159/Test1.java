package competition.oneweekrace.oneweekrace159;

public class Test1 {
	public boolean checkStraightLine(int[][] coordinates) {
		int len = coordinates.length;
		if(len<2) {
			return false;
		}
		if(len==2) {
			return true;
		}
		
		/*
		double x1 = coordinates[0][0];
		double y1 = coordinates[0][1];
		
		double x2 = coordinates[1][0];
		double y2 = coordinates[1][1];
		
		double m = (y1*x2-y2*x1)/(x1-x2);
		double n =(y1-m)/x1;
		*/
		double book = ((double)coordinates[1][1]-coordinates[0][1])/(coordinates[1][0]-coordinates[0][0]);
    	
        for(int i = 1;i<len-1;i++) {
			/*
			if(coordinates[i][1]!=n*coordinates[i][0]+m) {
				return false;
			}*/
        	double temp = ((double)coordinates[i][1]-coordinates[i+1][1])/(coordinates[i][0]-coordinates[i+1][0]);
        	
        	if(book!=temp) {
        		return false;
        	}
        	book = temp;
        }
        return true;
    }
}
/*
在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。

请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">true</font>，否则请返回 <font color="#c7254e" face="Menlo, Monaco, Consolas, Courier New, monospace">false</font>。

 

示例 1：



输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
输出：true
示例 2：



输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
输出：false
 

提示：

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates 中不含重复的点
*/