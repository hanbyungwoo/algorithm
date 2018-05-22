import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A2902 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine().toString();
		
		System.out.print(name.charAt(0));
		for(int i=1; i<name.length(); i++) {
			if(name.charAt(i) == '-') {
				System.out.print(name.charAt(i+1));
			}
		}
		
		
	}
}
