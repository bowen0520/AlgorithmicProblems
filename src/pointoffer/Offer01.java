package pointoffer;

public class Offer01 {
	public static void main(String[] args) {
		int target = 16;
		int[][] arr = {{}};
		System.out.println(new Offer01().Find(target, arr));
	}
	//非递归方法
	/*
	public boolean Find(int target, int [][] array) {
		if(array.length==0){
			return false;
		}
		int x = array.length-1;
		int y = 0;
		while(x>=0&&y<array.length) {//从左下角开始便利
			if(array[x][y]==target) {
				return true;
			}else if(array[x][y]>target) {
				x--;
			}else {
				y++;
			}
		}
		return false;
    }
    */
	//递归方法
	public boolean Find(int target, int [][] array) {
		if(array[0].length==0) {
			return false;
		}
		int x = array.length-1;		
		int y = 0;
		return Find(target, array, x, y);
    }
	public boolean Find(int target, int [][] array,int x,int y) {
		if(x<0||y>=array.length||y<0) {
			return false;
		}
		if(array[x][y]==target) {
			return true;
		}
		return array[x][y]>target?Find(target, array, --x, y):Find(target, array, x, ++y);
    }
}
/*
 * 题目描述 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数， 判断数组中是否含有该整数。
 */