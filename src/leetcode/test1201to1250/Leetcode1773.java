package leetcode.test1201to1250;

import java.util.List;

public class Leetcode1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int in = 0;
        int an = 0;

        if(ruleKey.equals("type")){
            in = 0;
        }else if(ruleKey.equals("color")){
            in = 1;
        }else{
            in = 2;
        }


        for(List<String> item: items){
            if(item.get(in).equals(ruleValue)) {
            	an++;
            }
        }
        
        return an;
    }
}
