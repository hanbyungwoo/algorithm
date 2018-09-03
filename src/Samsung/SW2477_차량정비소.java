package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW2477_차량정비소 {
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
			recep = new int [re+1];	// 접수창고 소요시간
			recepB = new int[re+1];	// 접수창고 이용하는 사람 번호 저장
			fix = new int [fi+1];	// 수리창고 소요시간		
			fixB = new int[fi+1];	// 수리창고 이용하는 사람 번호 저장
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
		while(complete()) {	// 모든 사람들의 접수가 끝났는지 확인
			// 대기 인원 일단 큐에 삽입
			Info_desk();
			// 접수 창고 종료된 사람 확인 후 수리 창고 큐에 삽입
			checkA();
			// 접수 창고 접수 중
			startA();
			// 수리 창고 종료된 사람 확인 후 종료 플래그 
			checkB();
			// 수리 창고 접수 중
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
		// 수리 끝난 사람 있는지 확인
		for(int i=1; i<fixB.length; i++) {
			if(fixB[i] == 0) continue;
			// 수리 끝
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
					in.A = i;	// 접수창고번호
					recepB[i] = in.seq;
					break;
				}
			}
		}
	}
	
	public static void checkA() {
		// 접수가 완료됨 이제 정비창구로 가야해
		for(int i=1; i<recepB.length; i++) {
			if(recepB[i] == 0) continue;
			// 접수완료
			if(min - info[recepB[i]].arriveA == recep[i]) {
				twoQ.add(info[recepB[i]]);
				recepB[i] = 0;
			}
		}
		
	}
	
	public static void Info_desk() {
		// 안내 데스크도착~
		// 접수 창고 큐에 넣기
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
	int A;	// 접수 창고 번호
	int B;	// 고장 창구 번호
	int arriveA;
	int arriveB;
	boolean complete;
	public Infor(int seq, int time) {
		this.seq = seq;
		this.time = time;
		this.complete = false;
	}

}

