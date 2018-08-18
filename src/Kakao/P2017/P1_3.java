package Kakao.P2017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1_3 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cacheSize = Integer.parseInt(br.readLine());
		String [] cities={"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		Queue<String> value = new LinkedList<String>();
		int time = 0;
		
		for(int i=0; i<cities.length; i++) {
			if(value.contains(cities[i])) {	// hit
				value.remove(cities[i]);
				value.add(cities[i]);
				time += 1;
			} else {	// miss
				if(value.size() < cacheSize) {
					value.add(cities[i]);
					time += 5;
				}
				else {
					value.poll();
					value.add(cities[i]);
					time += 5;
				}
			}
			
		}
		
		System.out.println(time);
		
	}

}
