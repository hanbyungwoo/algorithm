package Kakao.P2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1_3_Ä³½Ã {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cacheSize = Integer.parseInt(br.readLine());
		String [] cities={"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		Queue<String> value = new LinkedList<String>();
		int time = 0;
		
		for(int i=0; i<cities.length; i++) {
			String city = cities[i].toUpperCase();
			
			if(cacheSize == 0) {
				time = cities.length * 5;
				break;
			}
			
			if(value.contains(city)) {	// hit
				value.remove(city);
				value.add(city);
				time += 1;
			} else {	// miss
				if(value.size() < cacheSize) {
					value.add(city);
					time += 5;
				}
				else {
					value.poll();
					value.add(city);
					time += 5;
				}
			}
			
		}
		
		System.out.println(time);
		
	}

}
