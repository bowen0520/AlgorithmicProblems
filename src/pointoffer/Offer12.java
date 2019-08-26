package pointoffer;

public class Offer12 {
	/*
	public double Power(double base, int exponent) {
        return Math.pow(base, exponent);
	}
	*/
	public double Power(double base, int exponent) {
		if(base == 0) {
			if(exponent>0) {
				return 0d;
			}else {
				throw new RuntimeException("数据错误");
			}
		}
		
		if(exponent == 0) {
			return 1;
		}
		double answer = base;
		for(int i = 2;i<=(int)Math.abs(exponent);i++){
            answer *= base;
        }
		return exponent>0?answer:1/answer;
	}
	
}
/*
 * 题目描述 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */