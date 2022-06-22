package leetcode.test0901to0950;

import java.util.HashSet;
import java.util.Set;

public class Leetcode929 {
	public static void main(String[] args) {
		String[] emailStrings = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
		
		new Leetcode929().numUniqueEmails(emailStrings);
	}
	
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<String>();
        for(int i = 0; i < emails.length; i++) {
        	emailSet.add(formatEmails(emails[i]));
        }
        return emailSet.size();
    }
    
    public String formatEmails(String email) {
        int indexJ = email.indexOf("+");
        
        int indexA = email.indexOf("@");
        String start = email.substring(0, indexA);
        if(indexJ != -1) {
        	start = email.substring(0, indexJ);
        }
        
        start = start.replaceAll("\\.", "");
        
        return start + email.substring(indexA);
    }
}
