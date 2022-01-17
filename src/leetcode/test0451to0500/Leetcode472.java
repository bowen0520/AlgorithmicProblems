package leetcode.test0451to0500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
    	List<String> list = new ArrayList<String>();
    	
    	int[] book = new int[26];
    	
    	int[] cache = new int[26];
    	
    	int[] now = new int[26];
    	
    	int len = 0;
    	
    	Arrays.sort(words, (String a, String b) -> {return a.length() - b.length();});
    	
    	for(int i = 0; i < words.length; i++) {
    		if(words[i].length() > len) {
    			for(int j = 0; j < book.length; j++) {
    				book[j] = book[j] + cache[j];
    				cache[j] = 0;
    			}
    			len = words[i].length();
    		}
    		
    		
    		for(char c: words[i].toCharArray()) {
    			now[c - 'a']++;
    		}
    		
    		boolean flag = true;
    		
    		for(int j = 0; j < book.length; j++) {
				if(book[j] < now[j]) {
					flag = false;
					break;
				}
			}
    		
    		if(flag) {
    			list.add(words[i]);
    		}
    		
    		for(int j = 0; j < cache.length; j++) {
    			cache[j] = cache[j] + now[j];
    			now[j] = 0;
			}
    	}
    	
    	return list;
    }
}

class Solution {

    private Node root = new Node();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // 字典树 + DFS
        // 先使用字典树把所有单词放进去
        // 然后遍历每个单词是否可以在字典树中拆成多个单词
        // 为了方便，我们可以先把words按长度排个序
        // 这样，我们先遍历长度短的再遍历长度长的，可以边遍历边从字典树中查找边往字典树中放
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            if (!word.isEmpty()) {
                // 可以分割成多个单词，放入结果集中
                if (dfs(word, 0)) {
                    ans.add(word);
                } else {
                    // 是连接词的单词不用插入到字典树中
                    // 因为一个单词是连接词，说明字典树中存在多个更短的单词
                    // 即使一个更长的连接词由上述的连接词构成，它也可以拆成更多个更短的单词构成
                    // 比如，"abcd" 由 "ab" + "cd" 构成，同时存在另一个短单词 "ef"
                    // 那么，"abcdef" 可以由 "ab" + "cd" + "ef" 构成，不需要把 "abcd" 放入字典树
                    insert(word);
                }
            }
        }

        return ans;
    }

    /**
     * 插入单词到字典树中
     * @param word
     */
    private void insert(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            if (node.children[word.charAt(i) - 'a'] == null) {
                node.children[word.charAt(i) - 'a'] = new Node();
            }
            node = node.children[word.charAt(i) - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * 递归遍历单词，在字典树中寻找是否存在，遇到结束符则尝试分割单词
     * @param word 单词
     * @param i 单词中字符的索引
     * @return 可以分割为多个单词，返回 true，否则返回 false
     */
    private boolean dfs(String word, int i) {
        // 因为不存在重复的单词，所以，不会出现只包含一个单词的连接词
        if (i == word.length()) {
            return true;
        }

        Node node = this.root;
        while (i < word.length()) {
            // 如果不存在，返回false
            if (node.children[word.charAt(i) - 'a'] == null) {
                return false;
            }

            node = node.children[word.charAt(i) - 'a'];

            // 如果形成了一个完整的单词，深入下一层
            if (node.isEnd && dfs(word, i + 1)) {
                return true;
            }

            i++;
        }

        return false;
    }


    class Node {
        boolean isEnd;
        Node[] children;

        Node() {
            this.isEnd = false;
            this.children = new Node[26];
        }
    }

}
