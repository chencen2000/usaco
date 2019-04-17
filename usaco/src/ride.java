import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: chencen1
LANG: JAVA
TASK: ride
*/
public class ride {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		String l1=f.readLine();
		String l2=f.readLine();
		int i1=-1;
		int i2=-1;
		int sum=1;
		String result="";
		for(char c : l1.toCharArray()) {
			int i=c-'A'+1;
			sum*=i;
		}
		i1=sum % 47;
		sum=1;
		for(char c : l2.toCharArray()) {
			int i=c-'A'+1;
			sum*=i;
		}
		i2=sum % 47;
		if(i1==i2) {
			result="GO";
		}
		else
			result="STAY";
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		out.println(result);
		out.close();
		f.close();
	}

}
