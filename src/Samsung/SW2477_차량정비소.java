package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW2477_��������� {
	static int recep[]; 
	static int recepB[];
	static int fixB[];
	static int fix[];
	static Infor info[];
	static Queue<Infor> oneQ;
	static Queue<Infor> twoQ;
	static int min;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int re = Integer.parseInt(st.nextToken());
			int fi = Integer.parseInt(st.nextToken());
			int per = Integer.parseInt(st.nextToken());
			int find1 = Integer.parseInt(st.nextToken());
			int find2 = Integer.parseInt(st.nextToken());
			recep = new int [re+1];	// ����â�� �ҿ�ð�
			recepB = new int[re+1];	// ����â�� �̿��ϴ� ��� ��ȣ ����
			fix = new int [fi+1];	// ����â�� �ҿ�ð�		
			fixB = new int[fi+1];	// ����â�� �̿��ϴ� ��� ��ȣ ����
			info = new Infor[per+1];
			oneQ = new LinkedList<Infor>();
			twoQ = new LinkedList<Infor>();
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=re; i++) {
				recep[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=fi; i++) {
				fix[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=1; i<=per; i++) {
				int tt = Integer.parseInt(st.nextToken());
				info[i] = new Infor(i, tt);
			}
			
			solution();
			int ans = result(find1, find2);
			
			System.out.println("#"+ca+" "+ans);
			ca++;
		}
	}
	public static int result(int A, int B) {
		int rst = 0;
		for(int i=1; i<info.length; i++) {
			if(info[i].A == A && info[i].B == B) {
				rst += i;
			}
		}
		if(rst==0) rst=-1;
		return rst;
	}
	public static void solution() {
		min=0;
		while(complete()) {	// ��� ������� ������ �������� Ȯ��
			// ��� �ο� �ϴ� ť�� ����
			Info_desk();
			// ���� â�� ����� ��� Ȯ�� �� ���� â�� ť�� ����
			checkA();
			// ���� â�� ���� ��
			startA();
			// ���� â�� ����� ��� Ȯ�� �� ���� �÷��� 
			checkB();
			// ���� â�� ���� ��
			startB();
			min++;
			
		}
	}
	public static boolean possibleB() {
		for(int i=1; i<fixB.length; i++) {
			if(fixB[i]==0) {
				return true;
			}
		}
		return false;
	}
	
	public static void startB() {
		while(possibleB()) {
			if(twoQ.isEmpty()) break;
			Infor in = twoQ.poll();
			for(int i=1; i<fixB.length; i++) {
				if(fixB[i]==0) {
					fixB[i] = in.seq;
					in.B = i;
					in.arriveB = min;
					break;
				}
			}
		}
	}
	
	public static void checkB() {
		// ���� ���� ��� �ִ��� Ȯ��
		for(int i=1; i<fixB.length; i++) {
			if(fixB[i] == 0) continue;
			// ���� ��
			if(min - info[fixB[i]].arriveB == fix[i]) {
				info[fixB[i]].complete = true;
				fixB[i] = 0;
			}
		}
		
	}
	public static boolean possibleA() {
		for(int i=1; i<recepB.length; i++) {
			if(recepB[i]==0) {
				return true;
			}
		}
		return false;
	}
	
	public static void startA() {
		while(possibleA()) {
			if(oneQ.isEmpty()) break;
			Infor in = oneQ.poll();
			for(int i=1; i<recepB.length; i++) {
				if(recepB[i]==0) {
					in.arriveA = min;
					in.A = i;	// ����â���ȣ
					recepB[i] = in.seq;
					break;
				}
			}
		}
	}
	
	public static void checkA() {
		// ������ �Ϸ�� ���� ����â���� ������
		for(int i=1; i<recepB.length; i++) {
			if(recepB[i] == 0) continue;
			// �����Ϸ�
			if(min - info[recepB[i]].arriveA == recep[i]) {
				twoQ.add(info[recepB[i]]);
				recepB[i] = 0;
			}
		}
		
	}
	
	public static void Info_desk() {
		// �ȳ� ����ũ����~
		// ���� â�� ť�� �ֱ�
		for(int i=1; i<info.length; i++) {
			if(info[i].time == min) oneQ.add(info[i]);
		}
		
	}
	public static boolean complete() {
		for(int i=1; i<info.length; i++) {
			if(info[i].complete==false) {
				return true;
			}
		}
		return false;
	}
}
 

class Infor {
	int seq;
	int time;
	int A;	// ���� â�� ��ȣ
	int B;	// ���� â�� ��ȣ
	int arriveA;
	int arriveB;
	boolean complete;
	public Infor(int seq, int time) {
		this.seq = seq;
		this.time = time;
		this.complete = false;
	}

}

