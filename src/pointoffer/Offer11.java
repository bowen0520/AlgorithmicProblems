package pointoffer;

public class Offer11 {
	public static void main(String[] args) {
		
		System.out.println(new Offer11().NumberOf1(-2));
	}
	
	public int NumberOf1(int n) {
		int count = 0;
		while(n!=0) {
			if((n&1)==1) {
				count++;
			}
			n = n>>>1;
		}
		return count;
    }
	/*
	public int NumberOf1(int n) {
        char[] data = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for(int i = 0;i<data.length;i++){
            if(data[i]=='1'){
                count++;
            }
        }
        return count;
    }
	*/
	/*
	public int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
	*/
}
/*
 * 题目描述 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */