package pointoffer;

public class Offer30 {
	/*public int FindGreatestSumOfSubArray(int[] array) {
		int[][] books = new int[2][array.length];
		for(int i = 0;i<array.length;i++) {
			books[0][i] = 0;
			books[1][i] = Integer.MIN_VALUE;
		}
		for(int i = 0;i<array.length;i++) {
			for(int j = 0;j<=i;j++) {
				books[0][j] = books[0][j]+array[i];
				if(books[0][j]>books[1][j]) {
					books[1][j] = books[0][j];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<array.length;i++) {
			if(books[1][i]>max) {
				max = books[1][i];
			}
		}
		return max;
	}*/
	
	public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0){
            return 0;
        }
        int max = array[array.length-1];
        int count = 0;
        for(int i = array.length-1;i>=0;i--){
            count+=array[i];
            if(count>max){
                max = count;
            }
            if(count<=0){
                count = 0;
            }
        }
        return max;
    }
}
/*
题目描述
HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
*/