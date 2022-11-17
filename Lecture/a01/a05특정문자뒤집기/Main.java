package Lecture.a01.a05특정문자뒤집기;

import java.util.Scanner;

public class Main {
    public String solution(String str){

        String answer = "";
        int lt = 0, rt = str.length()-1;
        char[] c = str.toCharArray();

        while(lt<rt){

            if(Character.isAlphabetic(c[lt])) lt++;
            else if(Character.isAlphabetic(c[rt])) rt++;
            else{
            char temp = c[lt];
            c[lt] = c[rt];
            c[rt] = temp;

            rt--;
            lt++;
            }
        }

        answer = c.toString();
        
        return answer;

    }
    
    public static void main(String[] args) {
        Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str=kb.next();
		System.out.println(T.solution(str));

    }
}
