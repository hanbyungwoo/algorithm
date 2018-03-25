package bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A14888 {
	
	static int op[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int num[] = new int[n];
		int oper[] = new int[4];
		op = new int[n-1];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		int x=0;
		// 0 µ¡¼À 1 »¬¼À 2 °ö¼À 3 ³ª´°¼À
		for(int i=0; i<4; i++) {
			for(int j=0; j<oper[i]; j++) {
				op[x++] = i;
			}
		}
		
		
		int mid[] = new int[n-1];
		
		int max=-1000000000;
		int min=1000000000;
		
		do {
			// °è»êÀ» ¼öÇàÇÏÀÚ.
			if(op[0]==0) {	// µ¡¼À
				mid[0] = num[0]+num[1];
			} else if(op[0]==1) {	// »¬¼À
				mid[0] = num[0]-num[1];
			} else if(op[0]==2) {	// °ö¼À
				mid[0] = num[0]*num[1];
			} else {	// ³ª´°¼À 3ÀÏ °æ¿ì
				mid[0] = num[0]/num[1];
			}
			
			for(int i=2; i<op.length+1; i++) {
				if(op[i-1]==0) {	// µ¡¼À
					mid[i-1] = mid[i-2]+num[i];
				} else if(op[i-1]==1) {	// »¬¼À
					mid[i-1] = mid[i-2]-num[i];
				} else if(op[i-1]==2) {	// °ö¼À
					mid[i-1] = mid[i-2]*num[i];
				} else {	// ³ª´°¼À 3ÀÏ °æ¿ì
					mid[i-1] = mid[i-2]/num[i];
				}
			}
			if(mid[n-2] > max) {
				max = mid[n-2];
			}
			if(mid[n-2] < min) {
				min = mid[n-2];
			}
			
		} while(nextPerm());
		
		System.out.println(max);
		System.out.println(min);
	}
	static boolean nextPerm() {
		int temp = op.length - 1;
		while(temp>0 && op[temp-1] >= op[temp]) temp--;
		if(temp<=0) return false;
		int temp2 = op.length - 1;
		while(op[temp2] <= op[temp-1]) temp2--;
		swap(temp2, temp-1);
		temp2 = op.length - 1;
		while(temp < temp2) {
			swap(temp, temp2);
			temp++;
			temp2--;
		}
		return true;
	}

	static void swap(int a, int b) {
		int temp = op[a];
		op[a] = op[b];
		op[b]= temp;
	}
}

