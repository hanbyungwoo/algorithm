package Line.P2018_second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class L4 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().toString().split(" ");
			String[] req = str[1].split("/");
			if(str[0].equals("GET")) {
				if(req[1].equals("users")) {
					if(req.length < 4 || str.length > 2) {
						// 유저 아이디 생성하는 경우 중 잘못된 경우
						// data요청하는 건데.. 잘못된거
						print(405);
						continue;
					}
					if(map.containsKey(req[2])) {
						// 아이디 존재하는 경우
						String temp = map.get(req[2]);
						if(temp == null) {
							// 메시지 존재안함
							print(404);
						} else {
							// 메시지 존재
							System.out.println("200 OK " + temp);
						}
					} else {
						// 아이디 없음
						print(403);
					}
				} else {
					print(404);
				}
			} else {	// POST인 경우
				if(req[1].equals("users")) {
					if(!map.containsKey(req[2]) && req.length < 4) {
						// 아이디 미존재하는 경우
						map.put(req[2], null);
						print(201);
						continue;
					} else if(map.containsKey(req[2])&& req.length < 4) {
						// 아이디 이미 존재하는 경우
						print(403);
					}
					if(req.length > 3 && req[3].equals("data")) {
						// data 추가로 들어온 경우
						str[2] = str[2].replaceAll("value=", "");
						map.put(req[2], str[2]);
						print(200);
					} else {
						// GET요청인 경우.
						print(405);
					}
				} else {
					print(404);
				}
			}
			
			
			
		}
		
	}	
	
	public static void print(int number) {
		switch(number) {
		case 200 : System.out.println("200 OK"); break;
		case 201 : System.out.println("201 CREATED"); break;
		case 403 : System.out.println("403 FORBIDDEN"); break;
		case 404 : System.out.println("404 NOT_FOUND"); break;
		case 405 : System.out.println("405 METHOD_NOT_ALLOWED"); break;
		default : break;
		}
	}
}
