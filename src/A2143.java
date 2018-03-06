import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A2143 {
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long value = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		
		long arrA[] = new long[a];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++) {
			arrA[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		
		long arrB[] = new long[b];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<b; i++) {
			arrB[i] = Long.parseLong(st.nextToken());
		}
		
		ArrayList<Long> listA = new ArrayList<Long>();
		ArrayList<Long> listB = new ArrayList<Long>();
		
		listA = Sum(listA, arrA, a);
		listB = Sum(listB, arrB, b);
		
		Collections.sort(listA);
		Collections.sort(listB);
		Collections.reverse(listB);
		int l=0, r=0;
		int SizeA = listA.size();
		int SizeB = listB.size();
		int ans=0;
		// listA는 앞에서 부터
		// listB는 뒤에서 부터 숫자를 차례대로 봐줍니다.
		while(l<SizeA && r<SizeB) {
			if(listA.get(l) + listB.get(r) == value) {
				int ll=1;
				int rr=1;
				l++;
				r++;
				while(l<SizeA && listA.get(l) == listA.get(l-1)) {
					ll++;
					l++;
				}
				while(r<SizeB && listB.get(r) == listB.get(r-1)) {
					rr++;
					r++;
				}
				ans += ll*rr;
			} else if(listA.get(l) + listB.get(r) > value) {
				r++;
			} else {
				l++;
			}
		}
		System.out.println(ans);
	}
	// 인접한 배열의 숫자들을 다 더해서 ArrayList에 넣어줍니다.
	public static ArrayList<Long> Sum(ArrayList<Long> list, long arr[], int size) {
		for(int i=0; i<size; i++) {
			for(int j=i; j<size; j++) {
				long sum=0;
				for(int k=i; k<=j; k++) {
					sum += arr[k];
				}
				list.add(sum);
			}
		}
		
		return list;
	}
}
