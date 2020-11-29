import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/*
ID: chencen2000
LANG: JAVA
TASK: convention
*/
public class convention {

	static int N = 0;
	static int M = 0;
	static int C = 0;
	static int[] cows;

	public static void main(String[] args) throws IOException {
		// read input data
		BufferedReader f = new BufferedReader(new FileReader("convention.in"));
		String ln = f.readLine();
		String ss[] = ln.split(" ");
		N = Integer.parseInt(ss[0]);
		M = Integer.parseInt(ss[1]);
		C = Integer.parseInt(ss[2]);
		cows = new int[N];
		ln = f.readLine();
		ss = ln.split(" ");
		for(int i=0; i<N; i++) {
			int t = Integer.parseInt(ss[i]);
			cows[i]=t;
		}
		Arrays.sort(cows);
		f.close();

		// binary search
		int bot = 0;
		int top = cows[cows.length-1];
		while(bot<top-1){
			int mid = (bot+top)/2;
			int ret = works(mid);
			if(ret>0){
				top = mid;
			}
			else{
				bot = mid;
			}
		}

		// output 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		out.println(top);
		out.close();
	}

	static int works(int time){
		int ret = -1;
		int cow_arrived = 0;
		int bus_remaining = M;
		while(true){
			if (cow_arrived == N){
				ret = time;
				break;
			}
			if (bus_remaining == 0){
				break;
			}
			int cow_per_bus = 0;
			for(int i=cow_arrived; i<N; i++){
				if(cows[i]-cows[cow_arrived]>time){
					break;
				}
				if(cow_per_bus>=C) {
					break;
				}
				cow_per_bus += 1;
			}
			bus_remaining -= 1;
			cow_arrived += cow_per_bus;
		}
		return ret;
	}

}
