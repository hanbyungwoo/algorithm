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
		// �տ������� ���ؼ� ���� �� �ִ� ��� ���ڸ� �����Ѵ�.
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
		// ������������ ���ڵ鸸 ��������� �ش� ����� ����.
		for(int i = 1; i<=sum/2; i++) {
			if(sum%i == 0)
				v.add(i);
		}
		
		
		for(int i = 0; i<v.size(); i++) {
			boolean flag = true;
			int j = v.elementAt(i);
			while(j <= sum) {
				// �ش��ϴ� ���ڸ� ��� ���ؼ� �־���� �ϼ��Ǵ°���...
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


