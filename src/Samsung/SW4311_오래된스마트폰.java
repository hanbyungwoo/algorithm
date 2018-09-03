package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW4311_오래된스마트폰 {
	static int n, o, m, w, min;
	static boolean numbers[], opers[], avail[];
	static int touch[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			n = Integer.parseInt(st.nextToken());
			o = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			numbers = new boolean[10];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<n; i++) {
				numbers[Integer.parseInt(st.nextToken())] = true;
			}
			
			opers = new boolean[4];
			st = new StringTokenizer(br.readLine(), " ");
			// 1 +
			// 2 -
			// 3 *
			// 4 /
			
			for(int i=0; i<o; i++) {
				opers[Integer.parseInt(st.nextToken())-1] = true;
			}
			
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			touch = new int[1000];
			avail = new boolean[1000];
			
			Arrays.fill(touch, Integer.MAX_VALUE);
			
			if(numbers[0]) {
				touch[0] = 1;
				avail[0] = true;
			}
			
			if(numbers[0] && w==0) {
				System.out.println("#"+ (ca++) +" 1");
				continue;
			}
			
			for(int i=1; i<10; i++) {
				if(numbers[i]) {
					// 숫자만 터치하는 경우
					setTouch(i, 1);
				}
			}
			
			boolean isCheck = false;
			for(int i=1; i<1000; i++) {
				// 숫자로 만들어진것만 들어간다.
				// 그 외의 경우들은 최소 한 번 이상의 연산을 통해서 숫자가 만들어지기 떄문.
				if(avail[i]) {
					if(i==w) {
						isCheck = true;
						min = touch[i];
						break;
					}
					findMinTouch(i, touch[i]);
				}
			}
			
			if(min == Integer.MAX_VALUE) {
				min = -1;
			}
			else if(!isCheck) {
				min++;
			}
			
			System.out.println("#"+ca+" "+min);
			ca++;
		}
	}
	
	public static void setTouch(int num, int depth) {
		if(num < 0 || num > 999) {
			return;
		}
		touch[num] = depth;
		avail[num] = true;
		for(int i=0; i<10; i++) {
			if(numbers[i]) {
				setTouch(num*10+i, depth+1);
			}
		}
	}
	
	public static void findMinTouch(int num, int cnt) {
		// 1. 범위를 초과한 경우 : 더이상 탐색 불가능
		if(num < 0 || num > 999) return;
		// 2. 최소값 초과 
		if(cnt >= min) return;
		// 3. 탐색 횟수 초과 : 마지막에 = 연산을 하기 위해 -1을 해줌
		if(cnt > m-1) return;
		// 4. 목적 숫자에 도착
		if(num == w) {
			min = Math.min(min, cnt);
			return;
		}
		
		// 기존의 touch안에 숫자보다 값이 큰 경우
		if(touch[num] < cnt) return;
		// 계산이 아닌 숫자나열로만 만들어진 숫자인 경우
		if(!avail[num] && touch[num] == cnt) return;
		touch[num] = cnt;
		
		for(int i=1; i<1000; i++) {
			if(avail[i]) {
				if(opers[0]) findMinTouch(num+i, cnt+touch[i]+1);
				if(opers[1]) findMinTouch(num-i, cnt+touch[i]+1);
				if(opers[2] && i>1) findMinTouch(num*i, cnt+touch[i]+1);
				if(opers[3] && i>1) findMinTouch(num/i, cnt+touch[i]+1);
			}
		}
	}
}
