package leetcode.test0251to0300;

public class Leetcode273 {
	
	public static void main(String[] args) {
		System.out.println(new Leetcode273().numberToWords(2321));
	}
    public String numberToWords(int num) {
    	String an = "";
    	String[] arr = new String[] {""," Thousand "," Million "," Billion "};
    	for(int i = 0; i < 4; i++) {
    		int n = num%1000;
    		if(n!=0) {
    			an = help(n) + arr[i] + an;
    		}
    		num = num/1000;
    		if(num == 0) {
    			break;
    		}
    	}
    	//1 234 567 891
    	return an;
    }

    public String help(int num) {
        String an = "";
        int n = num/100;
        if(n > 0){
        	an = an + getStr(n) + " Hundred";
        }
        if(num%100 > 0 && num%100 < 20) {
        	an = an + getSpace(an) + getStr(num);
        }else {
        	int a = num%10;
            int b = num%100 - num%10;
            an = an + getSpace(an) + getStr(b);
            if(a > 0) {
            	an = an + getSpace(an) + getStr(a);
            }
		}
        return an;
    }
    
    public String getSpace(String an) {
        return an.length() > 0 ? " " : "";
    }

    public String getStr(int num) {
    	switch (num) {
		case 1:return "One";
		case 2:return "Two";
		case 3:return "three";
		case 4:return "four";
		case 5:return "five";
		case 6:return "six";
		case 7:return "seven";
		case 8:return "eight";
		case 9:return "nine";
		case 10:return "ten";
		case 11:return "eleven";
		case 12:return "twelve";
		case 13:return "thirteen";
		case 14:return "fourteen";
		case 15:return "fifteen";
		case 16:return "sixteen";
		case 17:return "seventeen";
		case 18:return "eighteen";
		case 19:return "nineteen";
		case 20:return "twenty";
		case 30:return "thirty";
		case 40:return "forty";
		case 50:return "fifty";
		case 60:return "sixty";
		case 70:return "seventy";
		case 80:return "eighty";
		case 90:return "ninety";
		default:return "One";
		}
    	//one、two、three、four、five、six、seven、eight、nine、ten、
    	//eleven、twelve、thirteen、fourteen、fifteen、sixteen、seventeen、eighteen、nineteen
    }
}
/*
 * 将非负整数 num 转换为其对应的英文表示。

 

示例 1：

输入：num = 123
输出："One Hundred Twenty Three"
示例 2：

输入：num = 12345
输出："Twelve Thousand Three Hundred Forty Five"
示例 3：

输入：num = 1234567
输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
示例 4：

输入：num = 1234567891
输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 

提示：

0 <= num <= 231 - 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/integer-to-english-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */