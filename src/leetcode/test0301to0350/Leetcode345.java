package leetcode.test0301to0350;

public class Leetcode345 {

	/*
	 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。

元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。

 

示例 1：

输入：s = "hello"
输出："holle"
示例 2：

输入：s = "leetcode"
输出："leotcede"
 

提示：

1 <= s.length <= 3 * 105
s 由 可打印的 ASCII 字符组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
    public String reverseVowels(String s) {
    	char[] cs = s.toCharArray();
    	int start = 0;
    	int end = cs.length - 1;
    	
    	while (start < end) {
			while(start < end && !isYY(cs[start])) {
				start++;
			}
			while(start < end && !isYY(cs[end])) {
				end--;
			}
			
			char temp = cs[start];
			cs[start] = cs[end];
			cs[end] = temp;
		}
    	
    	return new String(cs);
    }
    
    public boolean isYY(char c){
    	if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
    		return true;
    	}
    	
    	if(c == 'A' || c == 'E' ||c == 'I' ||c == 'O' ||c == 'U') {
    		return true;
    	}
    	
    	return false;
    }
}
