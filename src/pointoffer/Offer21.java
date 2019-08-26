package pointoffer;

import java.util.Stack;

public class Offer21 {
	/*public boolean IsPopOrder(int [] pushA,int [] popA) {
	      Stack<Integer> nums = new Stack<Integer>();
	      int push = 0;
	      int pop = 0;
	      while(pop<popA.length) {
	    	  if((!nums.isEmpty())&&nums.peek()==popA[pop]) {
	    		  pop++;
	    		  nums.pop();
	    		  continue;
	    	  }
	    	  if(push<pushA.length) {
		    	  nums.push(pushA[push]);
		    	  push++;
	    	  }else {
	    		  return false;
	    	  }
	      }
	      return true;
	}
	*/
	public boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA.length == popA.length) {
			if (pushA.length != 0) {
				Stack<Integer> s = new Stack<Integer>();
				int i = 0;
				for (int a = 0; a < pushA.length;) {
					s.push(pushA[a++]);
					while (i < popA.length && s.peek() == popA[i]) {
						s.pop();
						i++;
					}
				}
				return s.isEmpty();
			}
			return true;
		}
		return false;
	}
}
/*
题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
*/