package Kakao.P2018;

import java.util.ArrayList;

public class P1_6_매칭점수 {
	public static void main(String args[]) {
		solution("blind", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"});
	}
	
//	<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
//	<head>
//	  <meta charset="utf-8">
//	  <meta property="og:url" content="https://a.com"/>
//	</head>  
//	<body>
//	Blind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. 
//	<a href="https://b.com"> Link to b </a>
//	</body>
//	</html>
	
//	<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
//	<head>
//	  <meta charset="utf-8">
//	  <meta property="og:url" content="https://b.com"/>
//	</head>  
//	<body>
//	Suspendisse potenti. Vivamus venenatis tellus non turpis bibendum, 
//	<a href="https://a.com"> Link to a </a>
//	blind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.
//	<a href="https://c.com"> Link to c </a>
//	</body>
//	</html>
	
//	<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml">
//	<head>
//	  <meta charset="utf-8">
//	  <meta property="og:url" content="https://c.com"/>
//	</head>  
//	<body>
//	Ut condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind
//	<a href="https://a.com"> Link to a </a>
//	</body>
//	</html>
			
	public static int solution(String word, String[] pages) {
        int answer = 0;
        String url[] = new String[pages.length];
        ArrayList<String>[] outLinkUrl = (ArrayList<String>[]) new ArrayList[pages.length];
        
    	for(int i=0; i<pages.length; i++) {
    		outLinkUrl[i] = new ArrayList<String>();
    	}
        int outLink[] = new int[pages.length];
        int body[] = new int[pages.length];
        int total[] = new int[pages.length];
        
        for(int i=0; i<pages.length; i++) {
        	String uu[] = pages[i].split("content=");
        	uu = uu[1].split("/>");
        	// 주소
        	url[i] = uu[0].replaceAll("\"", "");
        	
        	// 외부링크 갯수
        	uu = pages[i].split("<a href=");
        	outLink[i] = uu.length-1;
        	
        	// 외부링크 주소
        	for(int j=1; j<uu.length; j++) {
        		String[] out = uu[j].split(">");
        		
        		outLinkUrl[i].add(out[0].replaceAll("\"",""));
        	}
//        	Blind Lorem Blind ipsum dolor Blind test sit am@et, consectetur adipiscing elit.
        	// 내용
        	uu = pages[i].split("<body>");
        	int cnt=0;
        	for(int j=1; j<uu.length; j++) {
        		String[] a;
        		a = uu[1].split("<a href");
            	a = a[0].split("\\s");
            	for(int k=1; k<a.length; k++) {
            		if(a[k].toUpperCase().equals(word.toUpperCase())) {
            			cnt++;
            		}
            	}
        	}
        	body[i] = cnt;
        	
        	
        }
        double help[] = new double[pages.length];
        for(int i=0; i<pages.length; i++) {
        	for(int j=0; j<outLinkUrl[i].size(); j++) {
        		int temp=0;
        		for(int k=0; k<pages.length; k++) {
        			if(url[k].equals(outLinkUrl[i].get(j))) {
        				help[k] += (double)body[j]/outLink[j];
        				temp++;
        			}
        		}
        	}
        }
        int max=0;
        for(int i=0; i<pages.length; i++) {
        	total[i] += body[i] + help[i];
        	System.out.println(total[i]);
        	if(max > total[i]) {
        		answer = i;
        	}
        }
        
        return answer;
    }
	
	
}