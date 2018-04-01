package Kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1_2 {
	public static void main(String[] args) {

        String[] testCase = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
        for (String s : testCase) {

            System.out.println(solution(s));
        }
    }

    public static int solution(String dartResult) {

        int[] score = new int[3];
        String[] num = dartResult.split("[SDT](\\#)?(\\*)?");
//        String[] num = dartResult.split("\\D+");
//        for(int i=0; i<num.length; i++) {
//        	System.out.print(num[i] + "-");
//        }
//        System.out.println();
        
//        if (!/^[a-zA-Z0-9]{10,15}$/.test(password)) {
//            alert("패스워드는 숫자와 영문자 조합으로 10~15자리를 사용해야 합니다");
//            return false;
//        }
//        if ($("#emp_enterDt").val() != "" && !/^[0-9]{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])/.test($("#emp_enterDt").val())) {
//            alert("입사일을 확인해주세요");
//            return false;
//        }
        String[] operator = dartResult.split("\\d+");
        
//        for(int i=0; i<operator.length; i++) {
//        	System.out.print(operator[i] + "-");
//        }
//        System.out.println();
        
        for (int i = 0; i < 3; i++) {

            char op1 = operator[i + 1].charAt(0);

            // S, D, T
            switch (op1) {

                case 'S':
                    score[i] = Integer.parseInt(num[i]);
                    break;

                case 'D':
                    score[i] = Integer.parseInt(num[i]);
                    score[i] *= score[i];
                    break;

                case 'T':
                    score[i] = Integer.parseInt(num[i]);
                    score[i] *= score[i] * score[i];
                    break;
            }

            // *, #
            if (operator[i + 1].length() > 1) {

                char op2 = operator[i + 1].charAt(1);

                switch (op2) {

                    case '*':
                        for (int j = (i - 1 < 0 ? 0 : i - 1); j <= i; j++) {

                            score[j] *= 2;
                        }
                        break;

                    case '#':
                        score[i] *= -1;
                        break;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 3; i++) {

            answer += score[i];
        }
        return answer;
    }


}
