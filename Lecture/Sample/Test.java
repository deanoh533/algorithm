package Lecture.Sample;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test {
       
    public static void main(String[] args) {
        Integer A[]=  {5,4,3,2,1};

        Arrays.sort(A);
        System.out.println("toString :"+Arrays.toString(A));
        System.out.println("A.toString : "+ A.toString());
        System.out.println("A : "+ A);

        Arrays.sort(A, Collections.reverseOrder());
        System.out.println("Arrays.sort(a, Collections.reverseOrder()) :" + Arrays.toString(A));
        System.out.println("A : "+ A);

    }
}
