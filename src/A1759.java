import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백트래킹
public class A1759 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String info[] = br.readLine().split(" ");
		
		String value[] = br.readLine().split(" ");
		Arrays.sort(value);
		
		// 4자리, 입력받은 문자들, 출력 문자열, 추가 자릿수 체크
		go(Integer.parseInt(info[0]), value, "", 0);
	}
	
	public static void go(int n, String[] value, String pass, int index) {
		if(pass.length() == n) {
			if(check(pass)) {
				System.out.println(pass);
			}
			return;
		}
		if(index >= value.length) return;
		// i번째 알파벳 사용 경우
		go(n, value, pass+value[index], index+1);
		// i번째 알파벳 사용 않는 경우
		go(n, value, pass, index+1);
	}
	
	public static boolean check(String pass) {
		int ja=0;
		int mo=0;
		for(int i=0; i<pass.length(); i++) {
			if(pass.charAt(i) =='a' || pass.charAt(i) =='e' || pass.charAt(i) =='i' || pass.charAt(i) =='o' || pass.charAt(i) =='u') {
				mo++;
			} else {
				ja++;
			}
		}
		return (ja >= 2 && mo >= 1);
	}
}
