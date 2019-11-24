package competition.oneweekrace.oneweekrace159;


public class Test3 {
	public static void main(String[] args) {
		int n = new Test3().balancedString("QWQR");
		System.out.println(n);
	}
	public int balancedString(String s) {
        int q = 0;
        int w = 0;
        int e = 0;
        int r = 0;
        char[] cs = s.toCharArray();
        
        for(int i = 0;i< cs.length;i++) {
        	switch(cs[i]) {
        	case 'Q':q++;break;
        	case 'W':w++;break;
        	case 'E':e++;break;
        	case 'R':r++;break;
        	}
        }
        
        int n = s.length()/4;
        
        
        int[] map = new int[4];
        
        map[0] = q-n>0?q-n:0;
        map[1] = w-n>0?w-n:0;
        map[2] = e-n>0?e-n:0;
        map[3] = r-n>0?r-n:0;
        
        if(0==map[0]&&0==map[1]&&0==map[2]&&0==map[3]){
            return 0;
        }
        
        int start =0;
        int end = 0;
        q = 0;
        w = 0;
        e = 0;
        r = 0;
        int len = cs.length;
        for(;end<cs.length;end++) {
        	switch(cs[end]) {
        	case 'Q':q++;break;
        	case 'W':w++;break;
        	case 'E':e++;break;
        	case 'R':r++;break;
        	}
        	while(q>=map[0]&&w>=map[1]&&e>=map[2]&&r>=map[3]) {
                int temp = end-start+1;
                if(len>temp){
                    len=temp;
                }
        		switch(cs[start]) {
            	case 'Q':q--;break;
            	case 'W':w--;break;
            	case 'E':e--;break;
            	case 'R':r--;break;
            	}
        		start++;
        	}
        }
        return len;
    }
}
/*
有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。

假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。

 

给你一个这样的字符串 s，请通过「替换子串」的方式，使原字符串 s 变成一个「平衡字符串」。

你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。

请返回待替换子串的最小可能长度。

如果原字符串自身就是一个平衡字符串，则返回 0。

 

示例 1：

输入：s = "QWER"
输出：0
解释：s 已经是平衡的了。
示例 2：

输入：s = "QQWE"
输出：1
解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
示例 3：

输入：s = "QQQW"
输出：2
解释：我们可以把前面的 "QQ" 替换成 "ER"。 
示例 4：

输入：s = "QQQQ"
输出：3
解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 

提示：

1 <= s.length <= 10^5
s.length 是 4 的倍数
s 中只含有 'Q', 'W', 'E', 'R' 四种字符
*/