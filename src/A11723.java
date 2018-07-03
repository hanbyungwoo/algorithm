import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A11723 {
		
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int loop = Integer.parseInt(st.nextToken());
		boolean arr[] = new boolean[21];
		
		for(int i=0; i<loop; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String op = st.nextToken().toString();
			int num=0;
			if(st.hasMoreTokens()) num = Integer.parseInt(st.nextToken()); 
			
			switch(op) {
			case "all" :
				Arrays.fill(arr, true);
				break;
				
			case "empty" :
				Arrays.fill(arr, false);
				break;
				
			case "add" :
				arr[num] = true;
				break;
				
			case "check" :
				if(arr[num]) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
				break;
				
			case "remove" :
				arr[num] = false;
				break;
				
			case "toggle" :
				if(arr[num]) {
					arr[num] = false;
				} else {
					arr[num] = true;
				}
				break;
			
			default : break;
			}
		}
		
		bw.close();
	}
	
	
}
