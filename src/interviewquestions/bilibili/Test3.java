package interviewquestions.bilibili;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] kys = s.split("#");
        List<String> list = new ArrayList<>();
        for(String ky:kys){
            String newStr = ky.replace(':',' ');
            if(newStr.trim().length()!=0){
                list.add(newStr);
            }
        }
        System.out.println(list.size());
        list.forEach(System.out::println);
    }
}
