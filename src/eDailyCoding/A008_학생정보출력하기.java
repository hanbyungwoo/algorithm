package eDailyCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A008_학생정보출력하기 {
	
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        
        for(int i=0; i<num; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	String temp = st.nextToken().toString();
        	int score = Integer.parseInt(st.nextToken());
        	
        	System.out.println(temp+" : "+score+"점");
        }
	       
    }
    
}
