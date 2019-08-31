package pointoffer;

public class Offer49 {
	public static void main(String[] args) {
		int n = new Offer49().StrToInt("-198");
		System.out.println(n);
	}
	
	public int StrToInt(String str) {
        char[] ss = str.toCharArray();
        boolean flag = true;
        int index = 0;
        if(ss[0]=='+'||ss[0]=='-') {
        	index++;
        	flag = (ss[0]=='+');
        }
        int ans = 0;
        for(int i = index;i<ss.length;i++) {
        	if(ss[i]<'0'||ss[i]>'9') {
        		return 0;
        	}
        	ans = ans*10+(ss[i]-'0');
        }
        return flag?ans:-ans;
    }
}
/*
题目描述
将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 数值为0或者字符串不是一个合法的数值则返回0。
输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0
示例1
输入
复制
+2147483647
    1a33
输出
复制
2147483647
    0
*/