
/*
 * 
 * 1. 두 배열 합치기
설명

오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.

두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.

세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.

네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.

각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.


출력
오름차순으로 정렬된 배열을 출력합니다.


예시 입력 1 

3
1 3 5
5
2 3 6 7 9
예시 출력 1

1 2 3 3 5 6 7 9
 */
package Lecture.a03.a01두배열합치기;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){

        ArrayList<Integer> answer = new ArrayList<>();
        
        int p1 = 0, p2 =0;
        while(p1<n && p2< m ){
            if ( a[p1] < b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while(p1<n){
            answer.add(a[p1++]);
        }
        while(p2<m){
            answer.add(b[p2++]);
        }
        return answer;
    }
    
    // public static void main(String[] args) {
    //     Main T = new Main();
	// 	Scanner kb = new Scanner(System.in);
    //     int n = kb.nextInt();
    //     int [] a = new int[n];
    //     for ( int i = 0; i<n ; i++){
    //         a[i]=kb.nextInt();
    //     }
    //     int m = kb.nextInt();
    //     int [] b = new int[m];
    //     for (int i = 0; i<m ; i++){
    //         b[i] = kb.nextInt();
    //     }
    //     for (int x : T.solution(n,m,a,b)) System.out.print(x+" ");
        
    // }

    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(reader.readLine());
        int [] a = new int[n];

        st = new StringTokenizer(reader.readLine());
        for ( int i = 0; i<n ; i++){
            a[i]= Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(reader.readLine());
        int [] b = new int[m];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i<m ; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        for (int x : T.solution(n,m,a,b)) System.out.print(x+" ");
        
    }
}
