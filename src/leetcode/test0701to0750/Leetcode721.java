package leetcode.test0701to0750;

import java.awt.Checkbox;
import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.ls.LSInput;

/*
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。

现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。

合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。

 

示例 1：

输入：
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
输出：
[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
解释：
第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。 
第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 

提示：

accounts的长度将在[1，1000]的范围内。
accounts[i]的长度将在[1，10]的范围内。
accounts[i][j]的长度将在[1，30]的范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/accounts-merge
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode721 {
	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
    	List<List<String>> anList = new ArrayList<List<String>>();
    	
    	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    	
    	for(int i = 0; i< accounts.size(); i++) {
    		String name = accounts.get(i).get(0);
    		if(map.containsKey(name)) {
    			List<Integer> list = map.get(name);
    			boolean flag = checkSame(i,list,accounts);
    			if(!flag) {
    				map.get(name).add(i);
    			}
    		}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(name, list);
			}
    	}
    	
    	for(List<Integer> list: map.values()) {
    		for(int i : list) {
    			anList.add(sortStrings(accounts.get(i)));
    		}
    	}
    	
    	return anList;
    }
    
    public List<String> sortStrings(List<String> list){
    	String name = list.get(0);
    	list.remove(0);
    	list.sort((a,b) -> {return a.compareTo(b);});
    	list.add(0, name);
    	return list;
    }
    
    
    public boolean checkSame(int i, List<Integer> list, List<List<String>> accounts) {
    	
    	for(int j:list) {
    		boolean flag = checkSame(i, j, accounts);
    		if(flag) {
    			return true;
    		}
    	}
    	
		return false;
	}
    
    public boolean checkSame(int i, int j, List<List<String>> accounts) {
    	
    	boolean flag = false;
    	
    	Set<String> set  = new HashSet<String>();
    	
    	List<String> email = accounts.get(j);
    	
    	for(int m = 1; m < email.size(); m++) {
    		set.add(email.get(m));
    	}
    	
    	List<String> email2 = accounts.get(i);
    	
    	for(int m = 1; m < email2.size(); m++) {
    		if(set.contains(email2.get(m))) {
    			flag = true;
    			break;
    		}
    	}
    	
    	if(flag) {
    		for(int m = 1; m < email2.size(); m++) {
        		set.add(email2.get(m));
        	}
    		
    		accounts.get(j).removeAll(set);
    		
    		accounts.get(j).addAll(set);
    	}
    	
		return flag;
	}
}
