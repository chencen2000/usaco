/*
ID: chencen1
LANG: JAVA
TASK: beads
 */
import java.io.*;
import java.util.*;
public class beads {
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		BufferedReader in = new BufferedReader(new FileReader("beads.in"));
		int size = Integer.parseInt(in.readLine());
		String beads = in.readLine();
		int inARow = 0;
		ArrayList<String> list = new ArrayList<String>();
		String[] temp = beads.split("");
		for(int i=0;i<size;i++){
			list.add(temp[i]);
		}
		int lastNumber = 0;
		for(int i=0;i<size;i++){
			inARow += length(list);
			Collections.reverse(list);
			inARow += length(list);
			Collections.reverse(list);
			list = rotate(list);
			if(lastNumber<inARow){
				lastNumber = inARow;
			}
			inARow = 0;
		}
		if(lastNumber>=size){
			lastNumber = size;
		}
		out.println(lastNumber);
		in.close();
		out.close();
	}
	public static ArrayList<String> rotate(ArrayList<String> list){
		list.add(list.get(0));
		list.remove(0);
		return list;
	}
	public static int length(ArrayList<String> list){
		int index = 0;
		int num = 0;
		String color = list.get(index);
		while(color.equals("w")){
			index++;
			if(index == list.size()){
				return index;
			}
			color = list.get(index);
		}
		for(int i=0;i<list.size();i++){
			String reader = list.get(i);
			if((reader.equals(color))||(reader.equals("w"))){
				num++;
			}else{
				break;
			}
		}
		return num;
	}
}
