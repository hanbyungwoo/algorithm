package Line.P2018_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class L1 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int money = 20000;
		
		while(st.hasMoreElements()) {
			int distance = Integer.parseInt(st.nextToken());
			if(distance < 4 || distance > 178) {
				break;
			}
			int pre = money;
			money -= charge(distance);
			if(money < 0) {
				money = pre;
				break;
			}
//			System.out.print(money + ", ");
		}
		System.out.println(money);
				
	}	
	
	public static int charge(int km) {
		if(km <= 40) {
			return 720;
		} else {
			km -= 40;
			int mok = km / 8;
			int div = km % 8;
			if(div == 0) {
				mok += -1;
			}
			return (mok+1)*80+720;
		}
	}
}
