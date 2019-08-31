package pointoffer;

public class Offer53 {
	public static void main(String[] args) {
		System.out.println(new Offer53().isNumeric("-.123".toCharArray()));
		//System.out.println(new Offer53().isInt("+6".toCharArray(),0,1));
		//System.out.println(new Offer53().isFloat("123.45".toCharArray(),0,5));
	}
	
	
	public boolean isNumeric(char[] str) {
        if(str.length==0){
            return false;
        }
        boolean hasE = false;
        boolean pointIndex = false;
        for(int i = 0;i<str.length;i++){
            if(str[i]=='+'||str[i]=='-'){
                if(i!=0&&str[i-1]!='e'&&str[i-1]!='E'){
                    return false;
                }
            }else if(str[i] == '.'){
                if(pointIndex||hasE||i+1>=str.length||str[i+1]<'0'||str[i+1]>'9'){
                    return false;
                }
                pointIndex = true;
                continue;
            }else if(str[i]=='E'||str[i]=='e'){
                if(hasE||i==str.length-1||str[str.length-1]<'0'||str[str.length-1]>'9'){
                    return false;
                }
                hasE = true;
            }else if(str[i]<'0'||str[i]>'9'){
                return false;
            }
        }
        return true;
    }
	
	
	/*public boolean isNumeric(char[] str) {
	    for(int i = 0;i<str.length;i++) {
	    	if(str[i]=='e'||str[i]=='E') {
	    		if(i==str.length-1) {
	    			return false;
	    		}
	    		return isFloat(str, 0, i-1)&&isInt(str, i+1, str.length-1);
	    	}
	    }
	    return isFloat(str, 0, str.length-1);
	}
	
	public boolean isFloat(char[] str,int star,int end) {
		int index = star;
	    if(str[index]=='+'||str[index]=='-') {
	    	index++;
	    }
	    if(index>end) {
	    	return false;
	    }
	    boolean books = false;
	    for(int i = index;i<=end;i++) {
	    	if(str[i]=='.') {
	    		if(books==true||(i+1)>=str.length||str[i+1]>'9'||str[i+1]<'0') {
	    			return false;
	    		}
	    		books = true;
	    		continue;
	    	}
	    	
	    	if(str[i]<'0'||str[i]>'9') {
	    		return false;
	    	}
	    }
	    return true;
	}
	
	public boolean isInt(char[] str,int star,int end) {
		int index = star;
	    if(str[index]=='+'||str[index]=='-') {
	    	index++;
	    }
	    if(index>end) {
	    	return false;
	    }
	    for(int i = index;i<=end;i++) {
	    	if(str[i]<'0'||str[i]>'9') {
	    		return false;
	    	}
	    }
	    return true;
	}*/
}
/*
题目描述
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
*/