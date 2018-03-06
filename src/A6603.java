import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A6603 {
	static ArrayList<Integer> list;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int num = Integer.parseInt(st.nextToken());
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> value = new ArrayList<Integer>();
			if(num ==0) {
				break;
			}
			for(int i=0; i<num; i++) {
				value.add(Integer.parseInt(st.nextToken()));
			}
			list = new ArrayList<Integer>();
			
			
			for(int i=0; i<6; i++) {
				list.add(1);
			}
			for(int i=0; i<num-6; i++) {
				list.add(2);
			}
			
			do {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				for(int i=0; i<num; i++) {
					if(list.get(i) == 1) {
						temp.add(value.get(i));
					}
				}
				result.add(temp);
			} while(nextPerm());
			
			for(int i=0; i<result.size(); i++) {
				for(int j=0; j<result.get(i).size(); j++) {
					System.out.print(result.get(i).get(j)+ " ");
				}
				System.out.println();
			}
			System.out.println();
		}
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
