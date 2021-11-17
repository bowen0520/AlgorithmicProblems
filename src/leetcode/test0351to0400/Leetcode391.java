package leetcode.test0351to0400;

public class Leetcode391 {
	
    public boolean isRectangleCover(int[][] rectangles) {
        int num = rectangles.length;
        
        boolean[] book = new boolean[rectangles.length];
        
        while(num > 1) {
        	int temp = num;
        	
        	for(int i = 0; i < rectangles.length; i++) {
        		if(!book[i]) {
	        		for(int j = 0; j < rectangles.length; j++) {
	            		if(!book[j] && i != j) {
	            			if(rectangles[i][0] == rectangles[j][0] && rectangles[i][2] == rectangles[j][2]) {
	            				if(rectangles[i][3] == rectangles[j][1]) {
		            				book[j] = true;
		            				num--;
		            				rectangles[i][3] = rectangles[j][3];
		            				rectangles[i][2] = rectangles[j][2];
		            			}else if(rectangles[i][1] == rectangles[j][3]) {
		            				book[j] = true;
		            				num--;
		            				rectangles[i][0] = rectangles[j][0];
		            				rectangles[i][1] = rectangles[j][1];
		            			}
	            			}else if(rectangles[i][1] == rectangles[j][1] && rectangles[i][3] == rectangles[j][3]) {
	            				if(rectangles[i][2] == rectangles[j][0]) {
		            				book[j] = true;
		            				num--;
		            				rectangles[i][3] = rectangles[j][3];
		            				rectangles[i][2] = rectangles[j][2];
		            			}else if(rectangles[i][0] == rectangles[j][2]) {
		            				book[j] = true;
		            				num--;
		            				rectangles[i][0] = rectangles[j][0];
		            				rectangles[i][1] = rectangles[j][1];
		            			}
	            			}
	            		}
	            	}
        		}
        	}
        	if(num == temp) {
        		return false;
        	}
        }
        
        return true;
    }

}
/*
给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。

如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。

 
示例 1：


输入：rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
输出：true
解释：5 个矩形一起可以精确地覆盖一个矩形区域。 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/perfect-rectangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/