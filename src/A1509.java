import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1509 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String temp = st.nextToken();
		int n = temp.length();
		temp = " " + temp;
		
		boolean c[][] = new boolean [n+1][n+1];
		int d[] = new int[n+1];
		
		
		for(int i=1; i<=n; i++) {
			c[i][i] = true; 
		}
		for(int i=1; i<=n-1; i++) {
			if(temp.charAt(i)==temp.charAt(i+1)) {
				c[i][i+1] = true;
			}
		}
		for(int k=2; k<n; k++) {
			for(int i=1; i<=n-k; i++) {
				int j = i+k;
				if(temp.charAt(i) == temp.charAt(j) && c[i+1][j-1]) {
					c[i][j] = true;
				}
			}
		}
		
		d[0]=0;
		for(int i=1; i<=n; i++) {
			d[i] = -1;
			for(int j=1; j<=i; j++) {
				if(c[j][i]) {
					if(d[i] == -1 || d[i] > d[j-1] + 1) {
						d[i] = d[j-1] + 1;
					}
				}
			}
		}
		
		System.out.println(d[n]);
		
		
	}
}
