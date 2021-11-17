package leetcode.test0151to0200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode187 {

    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> an = new ArrayList<String>();
    	
    	Map<String, Integer> book = new HashMap<String, Integer>();
    	
    	for(int i = 0; i < s.length() - 10; i++) {
    		String str = s.substring(i, i + 10);
    		book.put(str, book.getOrDefault(str, 0) + 1);
    		
    		if(book.getOrDefault(str, 0) == 2) {
    			an.add(str);
    		}
    	}
    	
    	return an;
    }
	
}
/*

所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

 

示例 1：

输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
输出：["AAAAACCCCC","CCCCCAAAAA"]
示例 2：

输入：s = "AAAAAAAAAAAAA"
输出：["AAAAAAAAAA"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/repeated-dna-sequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/