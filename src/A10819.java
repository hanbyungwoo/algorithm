import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A10819 {
	static ArrayList<Integer> list;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		list = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<num; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int sum = 0;
		
		do {
			int temp = cal();
			if(sum < temp) {
				sum = temp;
			}
		} while(nextPerm());
		
		System.out.println(sum);
	}
	
	static int cal() {
		int sum=0;
		for(int i=1; i<list.size(); i++) {
			sum = sum + getAbs(list.get(i-1) - list.get(i)); 
		}
		return sum;
	}
	
	static int getAbs(int a) {
		return a > 0 ? a : a*-1; 
	}
	static boolean nextPerm() {
		int temp = list.size() - 1;
		while(temp>0 && list.get(temp-1) >= list.get(temp)) temp--;
		if(temp<=0) return false;
		int temp2 = list.size()-1;
		while(list.get(temp2) <= list.get(temp-1)) temp2--;
		swap(temp2, temp-1);
		temp2 = list.size() - 1;
		while(temp < temp2) {
			swap(temp, temp2);
			temp++;
			temp2--;
		}
		return true;
	}

	static void swap(int a, int b) {
		int temp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
	}
}
