package woowahan;

import java.util.ArrayList;
import java.util.Collections;

public class P1_5 {
	public static void main(String args[]) {
//		int [] arr={6,1,4,6,3,2,7,4};
		int [] arr={2,1,1,3,2,1};
		System.out.println(Solution(arr, 4, 2));
	}
	
	public static int Solution(int[] A, int K, int L) {
		if(A.length < K+L) {
			return -1;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<A.length-K; i++) {
			int temp=0;
			
			for(int j=i; j<K+i; j++) {
				temp += A[j];
			}
			
			for(int j=K+i; j<=A.length-L; j++) {
				int temp2=0;
				for(int k=j; k<L+j; k++) {
					temp2 += A[k];
				}
				if(temp+temp2 > max) {
					max = temp+temp2;
				}
			}
		}
		
		return max;
	}
	
	
	
}

