package pointoffer;

public class Offer02 {
	public String replaceSpace(StringBuffer str) {
    	char[] cs = str.toString().toCharArray();
    	StringBuilder sBuilder = new StringBuilder();
    	for(char c:cs) {
    		sBuilder.append((c==' '?"%20":c));
    	}
    	return sBuilder.toString();
    }
}
/*
    *题目描述 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
    *例如，当字符串为We Are
 * Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */