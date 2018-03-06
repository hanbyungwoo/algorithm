import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1107 {
	static boolean broken[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int choice = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int bro = Integer.parseInt(st.nextToken());
		
		
		
		broken = new boolean[10];
		if(bro!=0) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<bro; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		int ans = choice - 100;
		if( ans < 0 ) {
			ans = -ans;
		}
		for(int i=0; i<=1000000; i++) {
			int c = i;
			int len = check(c);	// 길이를 잰다.
			if(len > 0) {
				int press = c - choice;	// +,- 체크
				if(press < 0) {
					press = -press; // + 누르는 경우
				}
				
				if(ans > press + len) {
					ans = press + len;
				}
			}
		}
		System.out.println(ans);
	}
	
	
	public static int check(int choice) {
		if(choice == 0) {
			if(broken[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		int len=0;
		while (choice > 0) {
			if (broken[choice % 10]) return 0;
			len += 1;
			choice /= 10;
		}
		return len;
	}
}
