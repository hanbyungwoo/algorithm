package woowahan;

import java.util.ArrayList;
import java.util.Collections;

public class P1_4 {
	public static void main(String args[]) {
		
		System.out.println(Solution(1, 1, 2, 3));
	}
	
	static ArrayList<Integer> list;
	public static int Solution(int A, int B, int C, int D) {
		list = new ArrayList<Integer>();
		list.add(A);
		list.add(B);
		list.add(C);
		list.add(D);
		
		Collections.sort(list);
		int max = Integer.MIN_VALUE;
		do {
			int temp = ((int)(Math.pow(list.get(0)-list.get(2), 2) + Math.pow(list.get(1)-list.get(3), 2)));
			if(temp > max) {
				max = temp;
			}
			
		} while(nextPerm());
		
		return max;
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

