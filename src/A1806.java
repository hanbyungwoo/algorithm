import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1806 {
	public static void main(String args[]) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int num = Integer.parseInt(st.nextToken());
		 int cnt = Integer.parseInt(st.nextToken());
		 
		 int value[] = new int[num+1];
		 st = new StringTokenizer(br.readLine(), " ");
		 
		 for(int i=0; i<num; i++) {
			 value[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 int min=Integer.MAX_VALUE;
//		 int ans = 0;
		 int sum=value[0];
		 int l=0, r=0;
		 while (l <= r && r < num) {
            if (sum < cnt) {
                r += 1;
                sum += value[r];
            } else if (sum == cnt) {
                min = Math.min(r-l+1,min);
                r += 1;
                sum += value[r];
            } else if (sum > cnt) {
            	min = Math.min(r-l+1,min);
                sum -= value[l];
                l++;
            }
        }
	
		 
		 if(min==Integer.MAX_VALUE) {
			 System.out.println("0");
		 } else {
			 System.out.println(min);
		 }
//		 System.out.println(ans);
	}
	
}