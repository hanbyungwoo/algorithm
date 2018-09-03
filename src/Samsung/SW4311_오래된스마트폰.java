package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW4311_�����Ƚ���Ʈ�� {
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
					// ���ڸ� ��ġ�ϴ� ���
					setTouch(i, 1);
				}
			}
			
			boolean isCheck = false;
			for(int i=1; i<1000; i++) {
				// ���ڷ� ��������͸� ����.
				// �� ���� ������ �ּ� �� �� �̻��� ������ ���ؼ� ���ڰ� ��������� ����.
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
		// 1. ������ �ʰ��� ��� : ���̻� Ž�� �Ұ���
		if(num < 0 || num > 999) return;
		// 2. �ּҰ� �ʰ� 
		if(cnt >= min) return;
		// 3. Ž�� Ƚ�� �ʰ� : �������� = ������ �ϱ� ���� -1�� ����
		if(cnt > m-1) return;
		// 4. ���� ���ڿ� ����
		if(num == w) {
			min = Math.min(min, cnt);
			return;
		}
		
		// ������ touch�ȿ� ���ں��� ���� ū ���
		if(touch[num] < cnt) return;
		// ����� �ƴ� ���ڳ����θ� ������� ������ ���
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
