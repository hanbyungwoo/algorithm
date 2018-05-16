import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		String b = Integer.toBinaryString(a);
		
		int max = 0;
		for(int i=0; i<b.length(); i++) {
			if(b.charAt(i) == '1') {
				int cnt=0;
				while(true) {
					i++;
					if(i==b.length()) {
						cnt=0;
						break;
					} else if(b.charAt(i) == '1') {
						i--;
						break;
					} else {
						cnt++;
					}
				}
				if(max < cnt) {
					max = cnt;
				}
			}
		}
		
		System.out.println(max);
		
    }
}











