package competition.oneweekrace.oneweekrace149;

public class Test4 {
	public int ordinalOfDate(String date) {
        String[] strs = date.split("-");
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);
        //（1-12月分别为31天，29天，31天，30天，31天，30天，31天，31天，30天，31天，30天，31天）
        int sum = 0;
        switch (month-1) {
		case 11:sum += 30;
		case 10:sum += 31;
		case 9:sum += 30;
		case 8:sum += 31;
		case 7:sum += 31;
		case 6:sum += 30;
		case 5:sum += 31;
		case 4:sum += 30;
		case 3:sum += 31;
		case 2:
			if(year%400==0||(year%4==0&&year%100!=0)) {
				sum += 29;
			}else {
				sum += 28;
			}
		case 1:sum += 31;
        }
        return sum+day;
    }
}
