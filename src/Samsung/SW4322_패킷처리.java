package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW4322_패킷처리 {
	static int n, min;
	static ArrayList<Packet> list;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ca=1;
		int t = Integer.parseInt(st.nextToken());
		while(t-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			list = new ArrayList<Packet>();
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new Packet(x, y));
			}
			
			
			
			
			System.out.println("#"+ca+" "+min);
			ca++;
		}
	}
}

class Packet {
	int sec;
	int len;
	public Packet(int sec, int len) {
		this.sec = sec;
		this.len = len;
	}
}






