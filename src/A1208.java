import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A1208 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int number = Integer.parseInt(st.nextToken());
		int value = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<number; i++) {
			if(i<number/2) {
				list.add(Integer.parseInt(st.nextToken()));
			} else {
				list2.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		list = caseCheck(list.size(), list);
		Collections.sort(list);
		list2 = caseCheck(list2.size(), list2);
		Collections.sort(list2);
		Collections.reverse(list2);
		
		long ans = 0;
		int l=0, r=0;
		
		while(l <list.size() && r <list2.size()) {
			if(list.get(l) + list2.get(r) == value) {
				long l1=1, r1=1;
				l++;
				r++;
				while(l<list.size() && list.get(l).equals(list.get(l-1)) ) {
					l1++;
					l++;
				}
				while(r<list2.size() && list2.get(r).equals(list2.get(r-1)) ) {
					r1++;
					r++;
				}
				ans += l1*r1;
			}
			else if(list.get(l) + list2.get(r) < value) {
				l++;
			}
			else {
				r++;
			}
		}
		if(value == 0) ans--;
		System.out.println(ans);
	}
	
	// 부분 집합 구하는 중.
	public static ArrayList<Integer> caseCheck(int size, ArrayList<Integer> arr) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i=0; i<(1<<size); i++) {
			int sum = 0;
			for(int j=0; j<size; j++) {
				if( (i&(1<<j)) != 0 ) {
					sum += arr.get(j);
				}
			}
			temp.add(sum);
		}
		
		return temp;
	}
}
