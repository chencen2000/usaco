/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: chencen1
LANG: JAVA
TASK: friday
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class friday {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] result=new int[7];
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		String line=f.readLine();
		int weekday=1;
		int years=Integer.parseInt(line);
		for(int y=1900; y<=1900+years-1; y++) {
			for(int m=1;m<=12;m++) {
				int days=getDays(m, y);
				for(int d=1;d<=days;d++) {
					weekday++;
					weekday %=7;
					if(d==13)
						result[weekday]++;
				}
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		for(int i=0; i<result.length; i++) {
			if(i>0)
				out.print(" ");
			out.print(result[i]);
		}
		out.println();
		out.close();
		f.close();
	}
	static int getDays(int month, int year) {
		int ret=0;
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
			ret=31;
		else if(month==4||month==6||month==9||month==11)
			ret=30;
		else if(month==2) {
			if(isLeapYear(year)) {
				ret=29;
			}
			else
				ret=28;
		}			
		return ret;
	}
	static boolean isLeapYear(int year) {
		boolean ret=false;
		if(year%100==0) {
			if(year%400==0)
				ret=true;		
		}
		else {
			if(year%4==0)
				ret=true;
		}
		return ret;
	}

}
