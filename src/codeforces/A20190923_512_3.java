package codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

public class A20190923_512_3 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		
		int arr[] = new int[n];
		int sum = 0;
		HashSet<Integer>  set = new HashSet<Integer>();
		// 앞에서부터 더해서 나올 수 있는 모든 숫자를 저장한다.
		for(int i = 0; i<n; i++) {
			arr[i] = s.charAt(i) - '0';
			sum += arr[i];
			set.add(sum);	
		}
		
		if(sum == 0) {
			System.out.println("YES");
			System.exit(0);
		}
		
		else if(sum == 1) {
			System.out.println("NO");
			System.exit(0);
		}
		
		
		Vector<Integer> v = new Vector<Integer>();
		// 나눠떨어지는 숫자들만 더했을경우 해당 결과가 나옴.
		for(int i = 1; i<=sum/2; i++) {
			if(sum%i == 0)
				v.add(i);
		}
		
		
		for(int i = 0; i<v.size(); i++) {
			boolean flag = true;
			int j = v.elementAt(i);
			while(j <= sum) {
				// 해당하는 숫자를 계속 더해서 있어야지 완성되는거임...
				if(!set.contains(j)) {
					flag = false;
					break;
				}	
				j += v.elementAt(i);
			}
			
			if(flag) {
				System.out.println("YES");
				System.exit(0);
			}
		}
		
		System.out.println("NO");
		in.close();

	}
}


