package leetcode.test0051to0100;

import java.util.ArrayList;
import java.util.List;

public class Leetcode068 {
	public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> list = new ArrayList<String>();
    	int start = 0;
    	int end = 0;
    	int len = 0;
    	for(String s: words) {
    		if(start == end) {
    			len += s.length();
    			end++;
    		}else {
				if(len + s.length() + 1 <= maxWidth) {
					len = len + s.length() + 1;
					end++;
				}else {
					list.add(getStr(words, start, end, len, maxWidth));
					start = end;
                    end++;
					len = s.length();
				}
			}
    	}
    	list.add(getStrend(words, start, maxWidth));
    	return list;
    }
    
    public String getStrend(String[] words, int start, int max) {
		String str = "";
		for(int i = start; i < words.length; i++) {
			if(i == start) {
				str = str + words[i];
			}else {
				str = str + " " + words[i];
			}
		}
		
		str += getSps(max - str.length());
		
		return str;
	}
    
    public String getStr(String[] words, int start, int end, int len, int max) {
		String str = "";
        if(end - start - 1 == 0){
            str = str + words[start] + getSps(max - words[start].length());
            return str;
        }
		int jb = (max - len + end - start - 1)/(end - start - 1);
		int dy = (max - len + end - start - 1)%(end - start - 1);
        System.out.println(jb + " " + dy);
		for(int i = start; i < end; i++) {
			if(i == start) {
				str = str + words[i];
			}else {
				str = str + getSps(jb + (dy>0?1:0)) + words[i];
				dy--;
			}
		}
		
		return str;
	}
    
    public String getSps(int n) {
		String str = "";
		for(int i = 0; i < n; i++) {
			str += " ";
		}
		return str;
	}
}
/*
给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。

你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。

要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

文本的最后一行应为左对齐，且单词之间不插入额外的空格。

说明:

单词是指由非空格字符组成的字符序列。
每个单词的长度大于 0，小于等于 maxWidth。
输入单词数组 words 至少包含一个单词。
示例:

输入:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
输出:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
示例 2:

输入:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
输出:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     因为最后一行应为左对齐，而不是左右两端对齐。       
     第二行同样为左对齐，这是因为这行只包含一个单词。
示例 3:

输入:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
输出:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

*/