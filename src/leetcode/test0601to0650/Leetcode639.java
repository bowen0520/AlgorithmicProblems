package leetcode.test0601to0650;

public class Leetcode639 {
	int yu = 1000000000 + 7;
    public int numDecodings(String s) {
    	int an = 0;
        if(s.charAt(0) == '*') {
        	for(int i = 1; i <= 9; i++) {
        		an += numDecodings(s.replaceFirst("[*]", i + ""));
        	}
        	return an%yu;
        }else if(s.length() >=2 && s.charAt(1) == '*'){
        	for(int i = 1; i <= 9; i++) {
        		an += numDecodings(s.replaceFirst("[*]", i + ""));
        	}
        	return an%yu;
		}else if(s.charAt(0) != '0'){
			if(s.length() <= 2) {
				int num = Integer.parseInt(s);
				if(num%10 == 0) {
					if(num/10 == 1 || num/10 == 2) {
						return 1;
					}
				}else {
					if(10 < num && num < 27) {
						return 2;
					}else {
						return 1;
					}
				}
			} else {
				int len = s.length() >= 2 ? 2 : 1;
				int num = Integer.parseInt(s.substring(0, len));
				if(num%10 == 0) {
					if(num/10 == 1 || num/10 == 2) {
						return numDecodings(s.substring(2))%yu;
					}
				}else {
					if(10 < num && num < 27) {
						return numDecodings(s.substring(1))%yu + numDecodings(s.substring(2))%yu;
					}else {
						return numDecodings(s.substring(1))%yu;
					}
				}
			}
		}
        
        return 0;
    }
    
    
    static final int MOD = 1000000007;

    public int numDecodings2(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c = f[i]
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = b * check1digit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    public int check1digit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    public int check2digits(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }
            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;
    }
}
/*
一条包含字母 A-Z 的消息通过以下的方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：

"AAJF" 对应分组 (1 1 10 6)
"KJF" 对应分组 (11 10 6)
注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。

除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。

给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。

由于答案数目可能非常大，返回对 109 + 7 取余 的结果。

 

示例 1：

输入：s = "*"
输出：9
解释：这一条编码消息可以表示 "1"、"2"、"3"、"4"、"5"、"6"、"7"、"8" 或 "9" 中的任意一条。
可以分别解码成字符串 "A"、"B"、"C"、"D"、"E"、"F"、"G"、"H" 和 "I" 。
因此，"*" 总共有 9 种解码方法。
示例 2：

输入：s = "1*"
输出：18
解释：这一条编码消息可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条。
每种消息都可以由 2 种方法解码（例如，"11" 可以解码成 "AA" 或 "K"）。
因此，"1*" 共有 9 * 2 = 18 种解码方法。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/