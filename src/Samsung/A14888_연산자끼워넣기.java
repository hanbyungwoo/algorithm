package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A14888_¿¬»êÀÚ³¢¿ö³Ö±â {
		
	static int op[];
	static int oper[];
	static long num[];
	static long max, min, cnt;
	static int n;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		num = new long[n];
		oper = new int[4];
		op = new int[n-1];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		int x=0;
		cnt=0;
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		// 0 µ¡¼À 1 »¬¼À 2 °ö¼À 3 ³ª´°¼À
		for(int i=0; i<4; i++) {
			for(int j=0; j<oper[i]; j++) {
				op[x++] = i;
				cnt+=i;
			}
		}
		
		cal(1, oper[0], oper[1], oper[2], oper[3], num[0]);
		System.out.println(max);
		System.out.println(min);
	}// µ¡¼À. –E¼À. °ö¼À. ³ª´°¼À
	
	public static void cal(int index, int plus, int minus, int mul, int div, long sum) {
		if(index==n) {
			min=Math.min(min, sum);
			max=Math.max(max, sum);
			
			return;
		}
		
		if(plus > 0) {
			cal(index+1, plus-1, minus, mul, div, sum+num[index]);
		}
		if(minus > 0) {
			cal(index+1, plus, minus-1, mul, div, sum-num[index]);
		}
		if(mul > 0) {
			cal(index+1, plus, minus, mul-1, div, sum*num[index]);
		}
		if(div > 0) {
			cal(index+1, plus, minus, mul, div-1, sum/num[index]);
		}
	}
}
